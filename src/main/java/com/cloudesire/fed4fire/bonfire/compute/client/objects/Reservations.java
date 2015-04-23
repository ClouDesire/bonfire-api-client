package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Reservations
{
	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class ExperimentItems
	{

		private String offset;
		private Integer total;
		protected List<Reservation> collection;


		@XmlElement (name="reservation")
		public List<Reservation> getCollection ()
		{
			return collection;
		}

		public void setCollection ( List<Reservation> collection )
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
	private ExperimentItems items;


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
	public ExperimentItems getItems ()
	{
		return items;
	}

	public void setItems ( ExperimentItems items )
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
