package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlType
@XmlRootElement (name = "instance", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Instance extends Resource
{

	public static class InstanceBuilder
	{
		String instanceType;
		String host;
		Locations.Location location;
		String cluster;
		Integer count;
		BigDecimal cpu;
		Integer memory;

		public InstanceBuilder setLocation( Location location )
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

		public InstanceBuilder setCluster( String cluster )
		{
			this.cluster = cluster;
			return this;
		}

		public InstanceBuilder setCount( Integer count )
		{
			this.count = count;
			return this;
		}

		public InstanceBuilder setMemory( Integer memory )
		{
			this.memory = memory;
			return this;
		}

		public InstanceBuilder setCpu( BigDecimal cpu )
		{
			this.cpu = cpu;
			return this;
		}

		public InstanceBuilder setInstanceType( String instanceType )
		{
			this.instanceType = instanceType;
			return this;
		}

		public InstanceBuilder setHost( String host )
		{
			this.host = host;
			return this;
		}

		public Instance build ()
		{
			if ( this.location == null || this.count == null || StringUtils.isBlank(instanceType) )throw new IllegalArgumentException("location, count and instanceType are required");
			Instance instance = new Instance();
			instance.setLocation(location);
			instance.setInstanceType(instanceType);
			if ( "custom".equals(instanceType) )
			{
				if ( cpu == null || memory == null ) throw new IllegalArgumentException("cpu and memory are required for a custom instance type");
				instance.setCpu(cpu);
				instance.setMemory(memory);
			}
			instance.setCount(count);
			instance.setCluster(cluster);
			instance.setHost(host);
			return instance;
		}
	}


	private String instanceType;
	private BigDecimal cpu;
	private Integer memory;
	private String host;

	@XmlElement (name = "instance_type")
	public String getInstanceType ()
	{
		return instanceType;
	}

	public void setInstanceType ( String instanceType )
	{
		this.instanceType = instanceType;
	}

	public String getHost ()
	{
		return host;
	}

	public void setHost ( String host )
	{
		this.host = host;
	}

	public BigDecimal getCpu ()
	{
		return cpu;
	}

	public void setCpu ( BigDecimal cpu )
	{
		this.cpu = cpu;
	}

	public Integer getMemory ()
	{
		return memory;
	}

	public void setMemory ( Integer memory )
	{
		this.memory = memory;
	}

	@Override public String toString ()
	{
		return "Instance{" +
				"instanceType='" + instanceType + '\'' +
				", cpu=" + cpu +
				", memory=" + memory +
				", host='" + host + '\'' +
				super.toString() +'}';
	}
}
