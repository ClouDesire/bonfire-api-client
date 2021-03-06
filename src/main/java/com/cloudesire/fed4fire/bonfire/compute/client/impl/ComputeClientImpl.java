package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.ComputeClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Compute;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.ComputeState;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Computes;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;
import com.google.common.util.concurrent.SettableFuture;

import java.net.MalformedURLException;
import java.util.concurrent.TimeoutException;

public class ComputeClientImpl extends BaseClientImpl<Compute,Computes> implements ComputeClient
{

	private final class CheckerTask extends BaseCheckerTask<Compute>
	{
		private CheckerTask(Integer entityId, SettableFuture<Compute> result, long end)
		{
			super(entityId, result, end);
		}

		@Override
		public void run() {
			client.getExecutorService().submit(new Runnable()
			{
				public void run ()
				{
					try
					{
						Thread.currentThread().setName( "Bonfire-compute-" + entityId );
						Compute compute = retrieve(entityId);

						if ( "pending".equals(compute.getState().toLowerCase()) || "prolog".equals(compute.getState().toLowerCase())
								|| "boot".equals(compute.getState().toLowerCase()) )
						{
							if (System.currentTimeMillis() > end)
							{
								result.setException(new TimeoutException( "Timeout expired" ));
								cancel();
							}

							return;
						}

						if ( "running".equals(compute.getState().toLowerCase()) )
						{
							result.set( compute );
							cancel();
						}
						else
						{
							result.setException( new IllegalStateException( "Compute status was: " +compute.getState()) );
							cancel();
						}

					} catch (Exception e)
					{
						result.setException(e);
						cancel();
					}
				}
			});
		}
	}

	public ComputeClientImpl ( BonfireComputeClientImpl client, String testbedName )
	{
		super( client,"locations/" + testbedName + "/computes", testbedName );
	}

	@Override protected Class<Compute> getEntityClass ()
	{
		return Compute.class;
	}

	@Override protected Class<Computes> getEntitiesClass ()
	{
		return Computes.class;
	}


	@Override public Compute create ( Integer experimentId, Compute entity ) throws MalformedURLException, RuntimeRestException, RestException
	{
		entity.setLocation(getLocation());
		return client.post( "experiments/" + experimentId + "/computes", entity );
	}

	@Override public Compute changeComputeState ( Integer computeId, ComputeState.State state )
			throws MalformedURLException, RuntimeRestException, RestException
	{
		return client.put( "locations/" + testbedName + "/computes/" + computeId, new ComputeState(state), Compute.class );
	}

	@Override public Compute update ( Compute entity, Integer id ) throws MalformedURLException, RuntimeRestException, RestException
	{
		entity.setLocation(getLocation());
		return client.put( entityUrl + "/" + id, entity );
	}

	@Override
	protected BaseCheckerTask<Compute> getCheckerTask( Integer entityId, SettableFuture<Compute> result, long end )
	{
		return new CheckerTask(entityId,result,end);
	}
}
