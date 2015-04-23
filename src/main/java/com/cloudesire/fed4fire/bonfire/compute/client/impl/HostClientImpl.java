package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.HostClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Hosts;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public class HostClientImpl extends BaseClientImpl<Hosts.Host, Hosts> implements HostClient
{
	public HostClientImpl ( BonfireComputeClientImpl client, String testbedName )
	{
		super(client, "locations/" + testbedName + "/hosts", testbedName );
	}

	@Override protected Class<Hosts.Host> getEntityClass ()
	{
		return Hosts.Host.class;
	}

	@Override protected Class<Hosts> getEntitiesClass ()
	{
		return Hosts.class;
	}

	@Override public Hosts.Host retrieve ( String hostName )
			throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.get( entityUrl + "/" + hostName, getEntityClass() );
	}
}
