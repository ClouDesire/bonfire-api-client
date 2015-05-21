package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlRootElement (name = "compute", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Compute extends Links
{

	public static enum Types
	{
		lite,small,medium,large;
	}

	public static class ComputeBuilder
	{
		private final String testbedName;
		private String name;
		private String host;
		private Integer osId;
		private List<Integer> networkIds = new ArrayList<>();
		private List<Integer> datadiskIds = new ArrayList<>();
		private String instanceType;


		public ComputeBuilder ( String testbedName )
		{
			this.testbedName = testbedName;
		}
		public ComputeBuilder setName( String name )
		{
			this.name = name;
			return this;
		}
		public ComputeBuilder setHost( String host )
		{
			this.host = host;
			return this;
		}
		public ComputeBuilder setOsId( Integer osId )
		{
			this.osId = osId;
			return this;
		}
		public ComputeBuilder addNetworkId( Integer networkId )
		{
			if ( networkId != null ) this.networkIds.add(networkId);
			return this;
		}
		public ComputeBuilder addDatadiskId( Integer datadiskId )
		{
			if ( datadiskId != null ) this.datadiskIds.add(datadiskId);
			return this;
		}
		public ComputeBuilder setInstanceType( Types instanceType )
		{
			this.instanceType = instanceType.toString();
			return this;
		}
		public ComputeBuilder setInstanceType( String instanceType )
		{
			this.instanceType = instanceType;
			return this;
		}

		public Compute build()
		{
			validateEntity();
			Compute compute = new Compute();


			compute.setName(name);
			compute.setInstanceType(new Compute.InstanceType(instanceType));
			compute.setHost(host);

			compute.setDisks(new ArrayList<Disk>());
			Compute.Disk disk = new Compute.Disk();
			disk.setStorage(new Storage("/locations/" + testbedName + "/storages/" + osId ));
			disk.setType("OS");
			//disks.setTarget("hda");
			compute.getDisks().add(disk);
			for ( Integer id : datadiskIds )
			{
				disk = new Compute.Disk();
				disk.setStorage(new Storage("/locations/" + testbedName + "/storages/" + id ));
				disk.setType("DATABLOCK");
				//disks.setTarget("hdb");
				compute.getDisks().add(disk);
			}
			if(!networkIds.isEmpty()) compute.setNics(new ArrayList<Nic>());
			for (Integer id : networkIds)
			{
				Compute.Nic nic = new Compute.Nic();
				nic.setNetwork(new Network("/locations/" + testbedName + "/networks/" + id));
				compute.getNics().add(nic);
			}
			return compute;
		}

		private void validateEntity ()
		{
			if (testbedName == null ) throw new IllegalArgumentException("testbedName cannot be null");
			if (name == null ) throw new IllegalArgumentException("name cannot be null");
			if (osId == null ) throw new IllegalArgumentException("osId cannot be null");
			if (networkIds.isEmpty()  ) throw new IllegalArgumentException("networkIds cannot be empty");
			if (instanceType == null ) throw new IllegalArgumentException("instanceType cannot be null");
		}
	}


	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class InstanceType
	{
		public InstanceType (){}
		public InstanceType (String value)
		{
			this.value = value;
		}

		private String value;
		private String href;

		@XmlValue
		public String getValue ()
		{
			return value;
		}

		public void setValue ( String value )
		{
			this.value = value;
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
			return "{" +
					"value='" + value + '\'' +
					", href='" + href + '\'' +
					'}';
		}
	}

	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Disk
	{

		private Integer id;
		private Storage storage;
		private String type;
		private String target;
		@XmlAttribute (name = "id")
		public Integer getId ()
		{
			return id;
		}

		public void setId ( Integer id )
		{
			this.id = id;
		}

		public Storage getStorage ()
		{
			return storage;
		}

		public void setStorage ( Storage storage )
		{
			this.storage = storage;
		}

		public String getType ()
		{
			return type;
		}

		public void setType ( String type )
		{
			this.type = type;
		}

		public String getTarget ()
		{
			return target;
		}

		public void setTarget ( String target )
		{
			this.target = target;
		}

		@Override public String toString ()
		{
			return "Disk{" +
					"id=" + id +
					", storage=" + storage +
					", type='" + type + '\'' +
					", target='" + target + '\'' +
					'}';
		}
	}
	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Nic
	{
		private Network network;
		private String ip;
		private String mac;

		public Network getNetwork ()
		{
			return network;
		}

		public void setNetwork ( Network network )
		{
			this.network = network;
		}

		public String getIp ()
		{
			return ip;
		}

		public void setIp ( String ip )
		{
			this.ip = ip;
		}

		public String getMac ()
		{
			return mac;
		}

		public void setMac ( String mac )
		{
			this.mac = mac;
		}

		@Override public String toString ()
		{
			return "Nic{" +
					"network=" + network +
					", ip='" + ip + '\'' +
					", mac='" + mac + '\'' +
					'}';
		}
	}

	private Integer id;
	private String href;
	private String nameAttribute;
	private String name;
	private Locations.Location location;
	private String groups;
	private String uname;
	private BigDecimal cpu;
	private Integer memory;
	private Compute.InstanceType instanceType;
	private String host;
	private String state;
	private List<Compute.Disk> disks;
	private List<Compute.Nic> nics;

	public Integer getId ()
	{
		return id;
	}

	public void setId ( Integer id )
	{
		this.id = id;
	}

	@XmlElement (name = "name")
	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public Locations.Location getLocation ()
	{
		return location;
	}

	public void setLocation ( Locations.Location location )
	{
		this.location = location;
	}

	public String getHost ()
	{
		return host;
	}

	public void setHost ( String host )
	{
		this.host = host;
	}

	public String getGroups ()
	{
		return groups;
	}

	public void setGroups ( String groups )
	{
		this.groups = groups;
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
	@XmlAttribute (name = "name")
	public String getNameAttribute ()
	{
		return nameAttribute;
	}

	public void setNameAttribute ( String nameAttribute )
	{
		this.nameAttribute = nameAttribute;
	}

	public String getUname ()
	{
		return uname;
	}

	public void setUname ( String uname )
	{
		this.uname = uname;
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

	@XmlElement (name = "instance_type")
	public Compute.InstanceType getInstanceType ()
	{
		return instanceType;
	}

	public void setInstanceType ( Compute.InstanceType instanceType )
	{
		this.instanceType = instanceType;
	}

	public String getState ()
	{
		return state;
	}

	public void setState ( String state )
	{
		this.state = state;
	}

	@XmlElement(name = "disk")
	public List<Compute.Disk> getDisks ()
	{
		return disks;
	}

	public void setDisks ( List<Compute.Disk> disks )
	{
		this.disks = disks;
	}
	@XmlElement(name = "nic")
	public List<Compute.Nic> getNics ()
	{
		return nics;
	}

	public void setNics ( List<Compute.Nic> nics )
	{
		this.nics = nics;
	}

	@Override public String toString ()
	{
		return "Compute{" +
				"id=" + id +
				", href='" + href + '\'' +
				", nameAttribute='" + nameAttribute + '\'' +
				", uname='" + uname + '\'' +
				", cpu=" + cpu +
				", memory=" + memory +
				", instanceType=" + instanceType +
				", state='" + state + '\'' +
				", disks=" + disks +
				", nics=" + nics +
				super.toString()+
				'}';
	}
}
