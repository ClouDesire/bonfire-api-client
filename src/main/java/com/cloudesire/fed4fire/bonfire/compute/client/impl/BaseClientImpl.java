package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.Crud;
import com.cloudesire.fed4fire.bonfire.compute.client.GetListenableFuture;
import com.cloudesire.fed4fire.bonfire.compute.client.RetrieveByExperimentId;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Locations;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class BaseClientImpl<T,A> implements Crud<T,A>, RetrieveByExperimentId<A>, GetListenableFuture<T>
{
	BonfireComputeClientImpl client;
	final String entityUrl;
	final String testbedName;

	public BaseClientImpl ( BonfireComputeClientImpl client, String entityUrl )
	{
		this.client = client;
		this.entityUrl = entityUrl;
		this.testbedName = null;
	}

	public BaseClientImpl ( BonfireComputeClientImpl client, String entityUrl, String testbedName )
	{
		this.client = client;
		this.entityUrl = entityUrl;
		this.testbedName = testbedName;
	}

	protected abstract Class<T> getEntityClass();

	protected abstract Class<A> getEntitiesClass();

	@Override public T create ( T entity ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.post( entityUrl, entity );
	}

	@Override public void delete ( Integer id ) throws MalformedURLException, RuntimeRestException, RestException
	{
		client.delete( entityUrl + "/" + id );
	}

	@Override public T retrieve ( Integer id ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.get( entityUrl + "/" + id, getEntityClass() );
	}

	@Override public A retrieveAll () throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.get( entityUrl, getEntitiesClass() );
	}

	@Override public T update ( T entity, Integer id ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.put( entityUrl + "/" + id, entity );
	}

	@Override public A retrieveByExperimentId ( Integer id ) throws MalformedURLException, RuntimeRestException, RestException
	{
		String[] strings = entityUrl.split("/");
		String entity = strings[strings.length - 1];
		return client.get( "experiments/" + id + "/" + entity, getEntitiesClass() );
	}

	protected Locations.Location getLocation ()
	{
		return new Locations.Location("/locations/" + testbedName);
	}

	@Override public ListenableFuture<T> getListenableFuture ( Integer entityId, long timeout, TimeUnit unit )
	{
		final SettableFuture<T> result = SettableFuture.create();
		final long end = System.currentTimeMillis() + unit.toMillis(timeout);
		client.getTimer().schedule(getCheckerTask(entityId, result, end), 5000, 10000);
		return result;
	}

	protected BaseCheckerTask<T> getCheckerTask( Integer entityId, SettableFuture<T> result, long end )
	{
		throw new UnsupportedOperationException();
	}

}
