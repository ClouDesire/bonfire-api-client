package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Hosts;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface HostClient extends RetrieveAll<Hosts>
{
	Hosts.Host retrieve ( String hostName ) throws MalformedURLException, RuntimeRestException, RestException;
}
