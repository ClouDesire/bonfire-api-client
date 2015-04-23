package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.ExperimentClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Experiment;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Experiments;

public class ExperimentClientImpl extends BaseClientImpl<Experiment, Experiments> implements ExperimentClient
{
	public ExperimentClientImpl ( BonfireComputeClientImpl client, String entityUrl )
	{
		super(client, entityUrl);
	}

	@Override protected Class<Experiment> getEntityClass ()
	{
		return Experiment.class;
	}

	@Override protected Class<Experiments> getEntitiesClass ()
	{
		return Experiments.class;
	}
}
