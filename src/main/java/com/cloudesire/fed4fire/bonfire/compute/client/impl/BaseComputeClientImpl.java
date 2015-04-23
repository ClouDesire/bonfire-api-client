package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.*;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Account;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public class BaseComputeClientImpl implements BaseComputeClient
{
	private final BonfireComputeClientImpl client;
	private final String testbedName;

	protected BaseComputeClientImpl ( BonfireComputeClientImpl client, String testbedName )
	{
		this.client = client;
		this.testbedName = testbedName;
	}

	@Override public StorageClient getStorageClient ()
	{
		return new StorageClientImpl ( client, testbedName );
	}

	@Override public NetworkClient getNetworkClient ()
	{
		return new NetworkClientImpl ( client, testbedName );
	}

	@Override public ConfigurationClient getConfigurationClient ()
	{
		return new ConfigurationClientImpl ( client, testbedName );
	}

	@Override public HostClient getHostClient ()
	{
		return new HostClientImpl ( client, testbedName );
	}

	@Override public Account retrieveAccount () throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.get( "locations/" + testbedName + "/account", Account.class );
	}

	@Override public ComputeClient getComputeClient ( )
	{
		return new ComputeClientImpl ( client, testbedName );
	}
}
