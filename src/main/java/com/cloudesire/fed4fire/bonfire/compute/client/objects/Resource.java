package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement (name = "instance", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
@XmlSeeAlso ({Core.class,Instance.class, Host.class})
public class Resource
{
	public enum Location
	{
		PL_PSNC, UK_EPCC, FR_INRIA
	}

	private Locations.Location location;
	private String cluster;
	private Integer count;

	public String getCluster ()
	{
		return cluster;
	}

	public void setCluster ( String cluster )
	{
		this.cluster = cluster;
	}


	public Locations.Location getLocation ()
	{
		return location;
	}

	public void setLocation ( Locations.Location location )
	{
		this.location = location;
	}

	public Integer getCount ()
	{
		return count;
	}

	public void setCount ( Integer count )
	{
		this.count = count;
	}

	@Override public String toString ()
	{
		return 	", location=" + location +
				", cluster='" + cluster + '\'' +
				", count=" + count;
	}
}
