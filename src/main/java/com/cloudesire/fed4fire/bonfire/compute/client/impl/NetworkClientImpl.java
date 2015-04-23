package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.NetworkClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Network;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Networks;

public class NetworkClientImpl extends BaseClientImpl<Network,Networks> implements NetworkClient
{

	public NetworkClientImpl ( BonfireComputeClientImpl client, String testbedName )
	{
		super( client,"locations/" + testbedName + "/networks", testbedName );
	}

	@Override protected Class<Network> getEntityClass ()
	{
		return Network.class;
	}

	@Override protected Class<Networks> getEntitiesClass ()
	{
		return Networks.class;
	}

}
