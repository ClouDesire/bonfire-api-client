package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.impl.BonfireComputeClientImpl;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.*;
import com.cloudesire.tisana4j.exceptions.RestException;
import com.cloudesire.tisana4j.exceptions.RuntimeRestException;
import com.google.common.util.concurrent.ListenableFuture;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainTest
{
	final static String LOGIN = "login";
	final static String PASSWORD = "password";

	public static void main ( String[] args ) throws Exception
	{
		/*remember to close the client or use AutoCloseable*/
		try (BonfireComputeClient client = new BonfireComputeClientImpl(LOGIN, PASSWORD))
		{
			/* Experiment Reservation by Instance example */

			InstanceReservation instanceReservation = new InstanceReservation();
			instanceReservation.setName("reservation_test");
			instanceReservation.setDescription("reservation test");
			instanceReservation.setGroups("master");
			instanceReservation.setWalltime(3600);
			instanceReservation.setStartTime(new Date());
			instanceReservation.getResources()
					.add(new Instance.InstanceBuilder().setInstanceType("small").setLocation(Resource.Location.FR_INRIA)
									.setCount(1).build());

			Reservation reservation = client.getReservationClient().create(instanceReservation);

			System.out.println(reservation);

			System.out.println(client.getReservationClient().retrieveAll());

			client.getReservationClient().delete(reservation.getId());

			/*************************/

			/* Experiment Creation example*/

			Experiment exp = new Experiment();

			exp.setName("group-test-002");
			exp.setDescription("experiment test");

			/*if a reservation was reserved set it here*/
			exp.setReservationId(reservation.getId());

			exp.setWalltime(3600);
			exp.setGroups("myGroup");

			Experiment experiment = client.getExperimentClient().create(exp);

			System.out.println(experiment);

			client.getExperimentClient().delete(experiment.getId());

			/*************************/

			/* Compute Creation example*/
			/*Storage creation*/

			Integer expId = experiment.getId();
			String testbedName = "fr-inria";

			Storage storage = new Storage.DataStorageBuilder().setName("test-storage").setDescription("storage test")
					.setSize(4096).build();

			storage = client.getCustomComputeClient(testbedName).getStorageClient().create(expId, storage);

			System.out.println(storage);

			/*Guava Future*/
			ListenableFuture<Storage> storageFuture = client.getCustomComputeClient(testbedName).getStorageClient()
					.getListenableFuture(storage.getId(), 1, TimeUnit.MINUTES);

			storage = storageFuture.get();

			System.out.println(storage);


			/*VM creation*/
			Compute compute = setupCompute(storage.getId(), testbedName);

			compute = client.getCustomComputeClient(testbedName).getComputeClient().create(expId, compute);

			System.out.println(compute);

			/*Guava Future*/
			ListenableFuture<Compute> computeFuture = client.getCustomComputeClient(testbedName).getComputeClient()
					.getListenableFuture(compute.getId(), 10, TimeUnit.MINUTES);

			/*Will block till completion..*/
			compute = computeFuture.get();

			System.out.println(compute);

			System.out.println(client.getInriaComputeClient().getComputeClient().retrieveAll());

			/*************************/
			/*Backup*/
			/*Beware this operation will destroy the actual VM but at the end of the operation it will be possible to create copies of her*/

			/*here we set the main Disk, OS diskId is 0, to be saved when the vm will be shutdown,
			the operation will return the location of the storage that will be created*/
			String osDiskBackup = client.getCustomComputeClient(testbedName).getStorageClient()
					.saveOsDiskAs(compute.getId(), "save_as_os_backup_test");
			System.out.println(osDiskBackup);

			/*if present, we set the datadisk to be saved, notice the diskId = 1*/
			String storageBackup = client.getCustomComputeClient(testbedName).getStorageClient().saveStorageAs(compute.getId(),
					1, "save_as_datadisk_backup_test");
			System.out.println(storageBackup);

			/*shutting down the vm*/
			client.getCustomComputeClient(testbedName).getComputeClient()
					.changeComputeState(compute.getId(), ComputeState.State.SHUTDOWN);

			Integer osDiskId = Integer.valueOf(osDiskBackup.substring(osDiskBackup.lastIndexOf('/') + 1 ));
			Integer storageId = Integer.valueOf(storageBackup.substring(storageBackup.lastIndexOf('/') + 1));

			/*Guava Future*/
			ListenableFuture<Storage> osdiskBackupFuture = client.getCustomComputeClient(testbedName).getStorageClient()
					.getListenableFuture(osDiskId, 5, TimeUnit.MINUTES);

			ListenableFuture<Storage> datadiskBackupFuture = client.getCustomComputeClient(testbedName).getStorageClient()
					.getListenableFuture(storageId, 5, TimeUnit.MINUTES);

			/*Will block till the backup storage is available*/
			Storage osdiskStorage = osdiskBackupFuture.get();
			System.out.println(osdiskStorage);

			Storage datadiskStorage = datadiskBackupFuture.get();
			System.out.println(datadiskStorage);

			/*Instead of the the custom Compute client, for this test we can use the Inria one. In this case it's unnecessary to pass the testbed name*/
			client.getInriaComputeClient().getStorageClient().delete(storage.getId());

		} catch (RestException e)
		{
			System.out.println("REST EXCEPTION CODE:" + e.getResponseCode() + " MESSAGE: " + e.getMessage());
		}
	}

	private static Compute setupCompute ( Integer datadiskId, String testbedName )
			throws RestException, RuntimeRestException, MalformedURLException
	{
		Integer publicNetworkId;
		Integer bonfireWANId;
		Integer osId;
		switch (testbedName)
		{
			case "fr-inria":
				publicNetworkId = 27;
				bonfireWANId = 53;
				osId = 3904;
				break;
			case "uk-epcc":
				publicNetworkId = 517;
				bonfireWANId = 105;
				osId = 4529;
				break;
			case "pl-psnc":
				osId = 1069;
				publicNetworkId = null;
				bonfireWANId = 0;
				break;
			default:
				System.out.println("Unknown testbed: " + testbedName);
				return null;
		}

		Compute.ComputeBuilder builder = new Compute.ComputeBuilder(testbedName).setName("test-compute")
				.setInstanceType(Compute.Types.small).addNetworkId(
						publicNetworkId) // Public Network: fr-inria:27 uk-epcc:517
				.addNetworkId(bonfireWANId) //Bonfire WAN : fr-inria: 53 uk-epcc: 105
				.setOsId(osId)  //BonFIRE Debian Squeeze 10G v6: fr-inria:3904 uk-epcc:4529
						//.setHost("bonfire-blade-1") //optional
				.addDatadiskId(datadiskId);
		return builder.build();
	}

}
