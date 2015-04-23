package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.RootClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Resources;


public class RootClientImpl extends BaseClientImpl<Resources,Resources> implements RootClient
{
	public RootClientImpl ( BonfireComputeClientImpl client, String entityUrl )
	{
		super(client, entityUrl);
	}

	@Override protected Class<Resources> getEntityClass ()
	{
		return Resources.class;
	}

	@Override protected Class<Resources> getEntitiesClass ()
	{
		return Resources.class;
	}
}
