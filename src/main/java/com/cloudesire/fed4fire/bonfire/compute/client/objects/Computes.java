package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Computes
{
	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class ComputeItems
	{

		private Integer offset;
		private Integer total;
		List<Compute> computes;

		@XmlAttribute(name = "offset")
		public Integer getOffset ()
		{
			return offset;
		}

		public void setOffset ( Integer offset )
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

		@XmlElement(name = "compute")
		public List<Compute> getComputes ()
		{
			return computes;
		}

		public void setComputes ( List<Compute> computes )
		{
			this.computes = computes;
		}

		@Override public String toString ()
		{
			return "ComputeItems{" +
					"offset=" + offset +
					", total=" + total +
					", computes=" + computes +
					'}';
		}
	}

	ComputeItems items;
	Links.Link link;

	@XmlElement (name = "link")
	public Links.Link getLink ()
	{
		return link;
	}

	public void setLink ( Links.Link link )
	{
		this.link = link;
	}

	@XmlElement (name = "items")
	public ComputeItems getItems ()
	{
		return items;
	}

	public void setItems ( ComputeItems items )
	{
		this.items = items;
	}

	@Override public String toString ()
	{
		return "Computes{" +
				"items=" + items +
				", link=" + link +
				'}';
	}
}
