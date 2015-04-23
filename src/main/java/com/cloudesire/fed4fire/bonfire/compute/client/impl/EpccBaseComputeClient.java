package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.BaseComputeClient;

public class EpccBaseComputeClient extends BaseComputeClientImpl implements BaseComputeClient
{
	public EpccBaseComputeClient ( BonfireComputeClientImpl client )
	{
		super(client,"uk-epcc");
	}

}
