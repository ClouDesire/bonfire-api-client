package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement (name = "core", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Core extends Resource
{

	public static class CoreBuilder
	{
		String host;
		Locations.Location location;
		String cluster;
		Integer count;

		public CoreBuilder setLocation( Location location )
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

		public CoreBuilder setCluster( String cluster )
		{
			this.cluster = cluster;
			return this;
		}

		public CoreBuilder setCount( Integer count )
		{
			this.count = count;
			return this;
		}
		public CoreBuilder setHost( String host )
		{
			this.host = host;
			return this;
		}

		public Core build ()
		{
			if ( this.location == null || this.count == null )throw new IllegalArgumentException("location and count are required");
			Core core = new Core();
			core.setLocation(location);
			core.setCount(count);
			core.setCluster(cluster);
			core.setHost(host);
			return core;
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
		return "Core{" +
				", host='" + host + '\'' +
				super.toString() +
				'}';
	}
}
