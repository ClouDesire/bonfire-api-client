package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.StorageClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Links;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Storage;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Storages;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;
import com.google.common.util.concurrent.SettableFuture;

import java.net.MalformedURLException;
import java.util.concurrent.TimeoutException;

public class StorageClientImpl extends BaseClientImpl<Storage,Storages> implements StorageClient
{
	private final class CheckerTask extends BaseCheckerTask<Storage>
	{
		private CheckerTask(Integer entityId, SettableFuture<Storage> result, long end)
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
						Thread.currentThread().setName("Bonfire-storage-" + entityId);
						Storage storage = retrieve(entityId);


						if ( "locked".equals(storage.getState().toLowerCase()) )
						{
							if (System.currentTimeMillis() > end)
							{
								result.setException(new TimeoutException( "Timeout expired" ));
								cancel();
							}

							return;
						}

						if ( "ready".equals(storage.getState().toLowerCase()) )
						{
							result.set( storage );
							cancel();
						}
						else
						{
							result.setException( new IllegalStateException( "Storage status was: " +storage.getState()) );
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

	public StorageClientImpl ( BonfireComputeClientImpl client, String testbedName )
	{
		super( client, "locations/" + testbedName + "/storages", testbedName );
	}

	@Override protected Class<Storage> getEntityClass ()
	{
		return Storage.class;
	}

	@Override protected Class<Storages> getEntitiesClass ()
	{
		return Storages.class;
	}

	@Override public Storage create ( Integer experimentId, Storage entity ) throws MalformedURLException, RuntimeRestException, RestException
	{
		entity.setLink(new Links.Link( "locations/" + testbedName, "location" ));
		return client.post( "experiments/" + experimentId + "/storages", entity );
	}

	@Override
	protected BaseCheckerTask<Storage> getCheckerTask( Integer entityId, SettableFuture<Storage> result, long end )
	{
		return new CheckerTask(entityId,result,end);
	}
}
