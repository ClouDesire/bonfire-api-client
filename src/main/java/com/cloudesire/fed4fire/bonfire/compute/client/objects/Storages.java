package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Storages
{

	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class StorageItems
	{
		private List<Storage> storages;

		@XmlElement (name="storage")
		public List<Storage> getStorages ()
		{
			return storages;
		}

		public void setStorages ( List<Storage> storages )
		{
			this.storages = storages;
		}

		@Override public String toString ()
		{
			return "StorageItems{" +
					"storages=" + storages +
					'}';
		}
	}

	private StorageItems items;

	@XmlElement (name = "items")
	public StorageItems getItems ()
	{
		return items;
	}

	public void setItems ( StorageItems items )
	{
		this.items = items;
	}

	@Override public String toString ()
	{
		return "Storages{" +
				"items=" + items +
				'}';
	}
}
