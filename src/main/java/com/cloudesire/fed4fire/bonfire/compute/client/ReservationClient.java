package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Reservation;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Reservations;

public interface ReservationClient extends Create<Reservation>, Retrieve<Reservation>, RetrieveAll<Reservations>, Delete
{

}
