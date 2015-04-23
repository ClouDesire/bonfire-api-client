package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Configurations;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface ConfigurationClient extends RetrieveAll<Configurations>
{
	Configurations.Configuration retrieve (String name) throws MalformedURLException, RuntimeRestException, RestException;
}
