package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Compute;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Computes;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface ComputeClient extends Retrieve<Compute>,RetrieveAll<Computes>, RetrieveByExperimentId<Computes>, Delete,
		GetListenableFuture<Compute>
{
	Compute create ( Integer experimentId, Compute entity ) throws MalformedURLException,
			RuntimeRestException, RestException;

}
