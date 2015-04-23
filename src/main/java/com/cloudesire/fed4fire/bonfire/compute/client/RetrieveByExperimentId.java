package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface RetrieveByExperimentId<T>
{
	T retrieveByExperimentId ( Integer id ) throws MalformedURLException, RuntimeRestException, RestException;
}
