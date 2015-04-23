package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Hosts
{
	@XmlType
	@XmlRootElement (name = "host", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Host extends Links
	{
		private String href;
		private String type;
		private String name;

		@XmlAttribute(name = "href")
		public String getHref ()
		{
			return href;
		}

		public void setHref ( String href )
		{
			this.href = href;
		}
		@XmlAttribute(name = "type")
		public String getType ()
		{
			return type;
		}

		public void setType ( String type )
		{
			this.type = type;
		}
		@XmlAttribute(name = "name")
		public String getName ()
		{
			return name;
		}

		public void setName ( String name )
		{
			this.name = name;
		}

		@Override public String toString ()
		{
			return "Host{" +
					"href='" + href + '\'' +
					", type='" + type + '\'' +
					", name='" + name + '\'' +
					super.toString() +
					'}';
		}
	}
	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class HostsItems
	{
		private List<Host> hosts;

		@XmlElement(name = "host")
		public List<Host> getHosts ()
		{
			return hosts;
		}

		public void setHosts ( List<Host> hosts )
		{
			this.hosts = hosts;
		}

		@Override public String toString ()
		{
			return "HostsItems{" +
					"hosts=" + hosts +
					'}';
		}
	}
	private HostsItems items;

	public HostsItems getItems ()
	{
		return items;
	}

	public void setItems ( HostsItems items )
	{
		this.items = items;
	}

	@Override public String toString ()
	{
		return "Hosts{" +
				"items=" + items +
				'}';
	}
}
