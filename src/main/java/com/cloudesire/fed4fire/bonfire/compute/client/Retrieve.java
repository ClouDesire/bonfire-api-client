package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface Retrieve<T>
{
	T retrieve (Integer id) throws MalformedURLException, RuntimeRestException, RestException;
}
