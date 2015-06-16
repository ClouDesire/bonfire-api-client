package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlType
@XmlRootElement (name = "reservation", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class HostReservation extends Reservation
{
	List<Host> resources = new LinkedList<>();

	@XmlElementWrapper
	@XmlElement(name="host")
	public List<Host> getResources ()
	{
		return resources;
	}


	@Override public String toString ()
	{
		return "Reservation{" +
				super.toString() +
				", resources=" + resources +
				'}';
	}
}
