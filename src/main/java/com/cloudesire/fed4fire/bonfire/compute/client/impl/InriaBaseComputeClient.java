package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.BaseComputeClient;

public class InriaBaseComputeClient extends BaseComputeClientImpl implements BaseComputeClient
{
	public InriaBaseComputeClient ( BonfireComputeClientImpl client )
	{
		super(client,"fr-inria");
	}

}
