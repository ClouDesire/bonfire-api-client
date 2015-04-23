package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.BaseComputeClient;

public class PsncBaseComputeClient extends BaseComputeClientImpl implements BaseComputeClient
{
	protected PsncBaseComputeClient ( BonfireComputeClientImpl client )
	{
		super(client, "pl-psnc");
	}
}
