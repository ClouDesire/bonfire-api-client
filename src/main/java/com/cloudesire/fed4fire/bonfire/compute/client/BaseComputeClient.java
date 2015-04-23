package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Account;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface BaseComputeClient
{
	StorageClient getStorageClient ();

	NetworkClient getNetworkClient();

	ConfigurationClient getConfigurationClient();

	HostClient getHostClient ();

	Account retrieveAccount () throws MalformedURLException, RuntimeRestException, RestException;

	ComputeClient getComputeClient ();

}
