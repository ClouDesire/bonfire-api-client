package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;

import java.net.MalformedURLException;

public interface Create<T>
{
	T create ( T entity ) throws MalformedURLException, RuntimeRestException, RestException;
}
