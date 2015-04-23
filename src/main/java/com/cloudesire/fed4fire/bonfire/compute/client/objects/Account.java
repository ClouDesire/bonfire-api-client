package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement (name = "account", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Account extends Links
{
	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Quota
	{
		private Integer memory;
		private Integer numVms;
		private String cpu;
		private Integer storage;

		public Integer getMemory ()
		{
			return memory;
		}

		public void setMemory ( Integer memory )
		{
			this.memory = memory;
		}

		@XmlElement (name = "num_vms")
		public Integer getNumVms ()
		{
			return numVms;
		}

		public void setNumVms ( Integer numVms )
		{
			this.numVms = numVms;
		}

		public String getCpu ()
		{
			return cpu;
		}

		public void setCpu ( String cpu )
		{
			this.cpu = cpu;
		}

		public Integer getStorage ()
		{
			return storage;
		}

		public void setStorage ( Integer storage )
		{
			this.storage = storage;
		}

		@Override public String toString ()
		{
			return "{" +
					"memory=" + memory +
					", numVms=" + numVms +
					", cpu='" + cpu + '\'' +
					", storage=" + storage +
					'}';
		}
	}



	private Integer id;
	private String href;
	private String name;
	private String group;
	private Quota quota;
	private Quota usage;

	public Integer getId ()
	{
		return id;
	}

	public void setId ( Integer id )
	{
		this.id = id;
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

	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public String getGroup ()
	{
		return group;
	}

	public void setGroup ( String group )
	{
		this.group = group;
	}

	public Quota getQuota ()
	{
		return quota;
	}

	public void setQuota ( Quota quota )
	{
		this.quota = quota;
	}

	public Quota getUsage ()
	{
		return usage;
	}

	public void setUsage ( Quota usage )
	{
		this.usage = usage;
	}

	@Override public String toString ()
	{
		return "Account{" +
				"id=" + id +
				", href='" + href + '\'' +
				", name='" + name + '\'' +
				", group='" + group + '\'' +
				", quota=" + quota +
				", usage=" + usage +
				super.toString() +
				'}';
	}
}
