package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Storage;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Storages;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface StorageClient extends RetrieveAll<Storages>, Retrieve<Storage>, RetrieveByExperimentId<Storages>, Delete,
		GetListenableFuture<Storage>
{
	Storage create ( Integer experimentId, Storage entity ) throws MalformedURLException,
			RuntimeRestException, RestException;
}
