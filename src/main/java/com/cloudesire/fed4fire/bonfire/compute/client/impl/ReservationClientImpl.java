package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.fed4fire.bonfire.compute.client.ReservationClient;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Reservation;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Reservations;

public class ReservationClientImpl extends BaseClientImpl<Reservation, Reservations> implements ReservationClient
{
	public ReservationClientImpl ( BonfireComputeClientImpl client, String entityUrl )
	{
		super(client, entityUrl);
	}

	@Override protected Class<Reservation> getEntityClass ()
	{
		return Reservation.class;
	}

	@Override protected Class<Reservations> getEntitiesClass ()
	{
		return Reservations.class;
	}

}
