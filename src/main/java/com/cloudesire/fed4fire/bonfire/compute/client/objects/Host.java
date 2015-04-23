package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement (name = "host", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Host extends Resource
{

	public static class HostBuilder
	{
		Locations.Location location;
		String cluster;
		Integer count;

		public HostBuilder setLocation( Location location )
		{
			switch (location)
			{
				case FR_INRIA:
					this.location = new Locations.Location("/locations/fr-inria");
					break;
				case UK_EPCC:
					this.location = new Locations.Location("/locations/uk-epcc");
					break;
				case PL_PSNC:
					this.location = new Locations.Location("/locations/pl-psnc");
					break;
				default:
					throw new IllegalArgumentException("Unknown location");
			}
			return this;
		}

		public HostBuilder setCluster( String cluster )
		{
			this.cluster = cluster;
			return this;
		}

		public HostBuilder setCount( Integer count )
		{
			this.count = count;
			return this;
		}

		public Host build ()
		{
			if ( this.location == null || this.count == null )throw new IllegalArgumentException("location and count are required");
			Host host = new Host();
			host.setLocation(location);
			host.setCount(count);
			host.setCluster(cluster);
			return host;
		}
	}

	private String host;

	public String getHost ()
	{
		return host;
	}

	public void setHost ( String host )
	{
		this.host = host;
	}

	@Override public String toString ()
	{
		return "Host{" +
				super.toString() +
				'}';
	}
}
