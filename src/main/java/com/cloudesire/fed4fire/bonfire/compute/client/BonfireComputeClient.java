package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.impl.EpccBaseComputeClient;
import com.cloudesire.fed4fire.bonfire.compute.client.impl.InriaBaseComputeClient;
import com.cloudesire.fed4fire.bonfire.compute.client.impl.PsncBaseComputeClient;

public interface BonfireComputeClient extends AutoCloseable
{
	RootClient getRootClient ();

	LocationClient getLocationClient ();

	ExperimentClient getExperimentClient ();

	ReservationClient getReservationClient ();

	BaseComputeClient getCustomComputeClient(String testbedName);

	InriaBaseComputeClient getInriaComputeClient ();

	EpccBaseComputeClient getEpccComputeClient ();

	PsncBaseComputeClient getPsncComputeClient ();
}
