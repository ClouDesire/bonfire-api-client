package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlType
@XmlRootElement (name = "reservation", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class InstanceReservation extends Reservation
{
	public InstanceReservation (){}

	List<Instance> resources = new LinkedList<>();

	@XmlElementWrapper
	@XmlElement(name="instance")
	public List<Instance> getResources ()
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
