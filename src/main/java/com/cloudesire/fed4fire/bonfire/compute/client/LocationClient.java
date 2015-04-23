package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Locations;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface LocationClient extends RetrieveAll<Locations>
{
	Locations.Location retrieve ( String name ) throws MalformedURLException, RuntimeRestException, RestException;
}
