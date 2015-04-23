package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.ConfigurationClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Configurations;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public class ConfigurationClientImpl extends BaseClientImpl<Configurations.Configuration,Configurations> implements
		ConfigurationClient
{
	public ConfigurationClientImpl ( BonfireComputeClientImpl client, String testbedName )
	{
		super( client,"locations/" + testbedName + "/configurations", testbedName );
	}

	@Override protected Class<Configurations.Configuration> getEntityClass ()
	{
		return Configurations.Configuration.class;
	}

	@Override protected Class<Configurations> getEntitiesClass ()
	{
		return Configurations.class;
	}

	@Override public Configurations.Configuration retrieve ( String name )
			throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.get( entityUrl + "/" + name, getEntityClass() );
	}
}
