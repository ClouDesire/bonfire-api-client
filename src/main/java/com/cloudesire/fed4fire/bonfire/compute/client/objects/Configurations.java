package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlRootElement (name = "collection", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Configurations
{
	@XmlType
	@XmlRootElement (name = "configuration", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Configuration extends Links
	{
		private String href;
		private String name;
		private Integer memory;
		private String cpu;

		public String getName ()
		{
			return name;
		}

		public void setName ( String name )
		{
			this.name = name;
		}

		public Integer getMemory ()
		{
			return memory;
		}

		public void setMemory ( Integer memory )
		{
			this.memory = memory;
		}

		public String getCpu ()
		{
			return cpu;
		}

		public void setCpu ( String cpu )
		{
			this.cpu = cpu;
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
			return "Configuration{" +
					"href='" + href + '\'' +
					", name='" + name + '\'' +
					", memory=" + memory +
					", cpu='" + cpu + '\'' +
					super.toString()+
					'}';
		}
	}

	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class ConfigurationsItems
	{
		private Integer offset;
		private Integer total;
		private List<Configuration> configurations;

		public Integer getOffset ()
		{
			return offset;
		}

		public void setOffset ( Integer offset )
		{
			this.offset = offset;
		}

		public Integer getTotal ()
		{
			return total;
		}

		public void setTotal ( Integer total )
		{
			this.total = total;
		}
		@XmlElement (name="configuration")
		public List<Configuration> getConfigurations ()
		{
			return configurations;
		}

		public void setConfigurations ( List<Configuration> configurations )
		{
			this.configurations = configurations;
		}

		@Override public String toString ()
		{
			return "ConfigurationsItems{" +
					"offset=" + offset +
					", total=" + total +
					", configurations=" + configurations +
					'}';
		}
	}

	private ConfigurationsItems items;

	@XmlElement (name="items")
	public ConfigurationsItems getItems ()
	{
		return items;
	}

	public void setItems ( ConfigurationsItems items )
	{
		this.items = items;
	}

	@Override public String toString ()
	{
		return "Collection{" +
				"items=" + items +
				'}';
	}
}
