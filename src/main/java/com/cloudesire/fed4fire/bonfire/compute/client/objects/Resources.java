package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "root", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Resources extends Links
{

	private Long timestamp;
	private String version;

	public Long getTimestamp ()
	{
		return timestamp;
	}

	public void setTimestamp ( Long timestamp )
	{
		this.timestamp = timestamp;
	}

	public String getVersion ()
	{
		return version;
	}

	public void setVersion ( String version )
	{
		this.version = version;
	}


	@Override public String toString ()
	{
		return "Resources{" +
				"timestamp=" + timestamp +
				", version='" + version + '\'' +
				super.toString() +
				'}';
	}
}
