package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.LocationClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Locations;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public class LocationClientImpl extends BaseClientImpl<Locations.Location,Locations> implements LocationClient
{
	public LocationClientImpl ( BonfireComputeClientImpl client, String entityUrl )
	{
		super(client, entityUrl);
	}

	@Override protected Class<Locations.Location> getEntityClass ()
	{
		return Locations.Location.class;
	}

	@Override protected Class<Locations> getEntitiesClass ()
	{
		return Locations.class;
	}

	@Override public Locations.Location retrieve ( String name )
			throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.get( entityUrl + "/" + name, getEntityClass() );
	}
}
