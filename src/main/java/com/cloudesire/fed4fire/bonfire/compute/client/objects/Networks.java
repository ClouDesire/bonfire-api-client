package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Networks
{

	@XmlType
	@XmlAccessorType ( value = XmlAccessType.PROPERTY )
	public static class NetworkItems
	{

		private String href;
		private Links.Link link;
		protected List<Network> networks;

		@XmlElement (name="network")
		public List<Network> getNetworks ()
		{
			return networks;
		}

		public void setNetworks ( List<Network> networks )
		{
			this.networks = networks;
		}

		@XmlElement ( name = "link" )
		public Links.Link getLink ()
		{
			return link;
		}

		public void setLink ( Links.Link link )
		{
			this.link = link;
		}

		@XmlAttribute ( name = "href" )
		public String getHref ()
		{
			return href;
		}

		public void setHref ( String href )
		{
			this.href = href;
		}

		@Override public String toString ()
		{
			return "NetworksItems{" +
					"href='" + href + '\'' +
					", link=" + link +
					", networks=" + networks +
					'}';
		}
	}

	private NetworkItems items;

	@XmlElement (name = "items")
	public NetworkItems getItems ()
	{
		return items;
	}

	public void setItems ( NetworkItems items )
	{
		this.items = items;
	}

	@Override public String toString ()
	{
		return "Networks{" +
				"items=" + items +
				'}';
	}
}
