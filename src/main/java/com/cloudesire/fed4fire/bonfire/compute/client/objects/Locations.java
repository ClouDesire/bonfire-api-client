package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Locations
{

	@XmlType
	@XmlRootElement (name = "location", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Location extends Links
	{
		public Location (){}

		public Location (String href)
		{
			this.href = href;
		}

		private String href;
		private String name;
		private String url;

		@XmlAttribute (name = "href")
		public String getHref ()
		{
			return href;
		}

		public void setHref ( String href )
		{
			this.href = href;
		}

		public String getName ()
		{
			return name;
		}

		public void setName ( String name )
		{
			this.name = name;
		}

		public String getUrl ()
		{
			return url;
		}

		public void setUrl ( String url )
		{
			this.url = url;
		}

		@Override public String toString ()
		{
			return "Location{" +
					"href='" + href + '\'' +
					", name='" + name + '\'' +
					", url='" + url + '\'' +
					super.toString() + '}';
		}
	}

	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class LocationItems
	{

		private String offset;
		private Integer total;
		protected List<Location> collection;


		@XmlElement (name="location")
		public List<Location> getCollection ()
		{
			return collection;
		}

		public void setCollection ( List<Location> collection )
		{
			this.collection = collection;
		}

		@XmlAttribute (name = "offset")
		public String getOffset ()
		{
			return offset;
		}

		public void setOffset ( String offset )
		{
			this.offset = offset;
		}
		@XmlAttribute (name = "total")
		public Integer getTotal ()
		{
			return total;
		}

		public void setTotal ( Integer total )
		{
			this.total = total;
		}

		@Override public String toString ()
		{
			return "Items{" +
					"offset='" + offset + '\'' +
					", total=" + total +
					", collection=" + collection +
					'}';
		}
	}

	private String href;
	private Links.Link link;
	private LocationItems items;


	@XmlElement (name="link")
	public Links.Link getLink ()
	{
		return link;
	}

	public void setLink ( Links.Link link )
	{
		this.link = link;
	}
	@XmlElement (name = "items")
	public LocationItems getItems ()
	{
		return items;
	}

	public void setItems ( LocationItems items )
	{
		this.items = items;
	}

	@XmlAttribute (name = "href")
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
		return "Locations{" +
				"href='" + href + '\'' +
				", link=" + link +
				", items=" + items +
				'}';
	}

}
