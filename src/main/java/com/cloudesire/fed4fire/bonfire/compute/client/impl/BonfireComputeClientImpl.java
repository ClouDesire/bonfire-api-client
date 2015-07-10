package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.*;
import com.cloudesire.tisana4j.RestClient;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BonfireComputeClientImpl implements BonfireComputeClient
{
	private final String login;
	private final String password;

	private final static String BASE_URL="https://api.bonfire-project.eu";
	private final static String CONTENT_TYPE ="application/vnd.bonfire+xml";
	public static final int CORE_POOL_SIZE = 4;
	public static final int MAXIMUM_POOL_SIZE = 10;
	private ListeningExecutorService executorService;
	private final Timer timer = new Timer(true);

	RestClient getClient()
	{
		RestClient client = new RestClient(login, password, true);
		client.setUseXml(true);
		Map<String,String> headers = new HashMap<>();
		headers.put("Accept",CONTENT_TYPE);
		headers.put("Content-Type", CONTENT_TYPE);
		//headers.put("Accept","*/*");
		client.setHeaders(headers);
		client.setExceptionTranslator(new BonfireExceptionTranslator());
		return client;
	}


	public BonfireComputeClientImpl ( String login, String password )
	{
		this.login=login;
		this.password=password;
		ThreadFactoryBuilder threadFactory = new ThreadFactoryBuilder();
		threadFactory.setThreadFactory(Executors.defaultThreadFactory());
		threadFactory.setNameFormat("bonfire-client-pool-%d");
		this.executorService = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(),threadFactory.build()));
	}



	@Override public void close () throws Exception
	{
		timer.cancel();
		executorService.shutdown();
	}

	protected URL getUrl(String path) throws MalformedURLException
	{
		path = path != null ? path : "";
		return new URL(BASE_URL+"/"+path);
	}

	protected <T> T get( String entityUrl, Class<T> clazz ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return getClient().get(getUrl(entityUrl), clazz);
	}

	protected <T> T post( String entityUrl, T entity ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return getClient().post(getUrl(entityUrl), entity);
	}

	protected <T> T put( String entityUrl, T entity ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return getClient().put(getUrl(entityUrl), entity);
	}

	protected <T,E> T put( String entityUrl, E entity, Class<T> responseClass ) throws MalformedURLException, RuntimeRestException, RestException
	{
		return getClient().put(getUrl(entityUrl), entity, null, responseClass );
	}


	protected void delete( String entityUrl ) throws MalformedURLException, RuntimeRestException, RestException
	{
		getClient().delete(getUrl(entityUrl) );
	}

	protected ListeningExecutorService getExecutorService()
	{
		return executorService;
	}

	protected Timer getTimer()
	{
		return timer;
	}

	@Override
	public RootClient getRootClient ()
	{
		return new RootClientImpl(this,null);
	}

	@Override public LocationClient getLocationClient ()
	{
		return new LocationClientImpl(this,"locations");
	}

	@Override public ExperimentClient getExperimentClient ()
	{
		return new ExperimentClientImpl(this,"experiments");
	}

	@Override public ReservationClient getReservationClient ()
	{
		return new ReservationClientImpl(this,"reservations");
	}

	@Override public BaseComputeClient getCustomComputeClient ( String testbedName )
	{
		return new BaseComputeClientImpl(this, testbedName);
	}

	@Override public InriaBaseComputeClient getInriaComputeClient ()
	{
		return new InriaBaseComputeClient(this);
	}

	@Override public EpccBaseComputeClient getEpccComputeClient ()
	{
		return new EpccBaseComputeClient(this);
	}

	@Override public PsncBaseComputeClient getPsncComputeClient ()
	{
		return new PsncBaseComputeClient(this);
	}


}
