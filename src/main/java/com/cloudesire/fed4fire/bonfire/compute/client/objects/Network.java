package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;


@XmlType
@XmlRootElement (name = "network", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Network
{

	@XmlType
	@XmlAccessorType (value = XmlAccessType.PROPERTY)
	public static class Uname
	{
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


	public Network (){}

	public Network (String href)
	{
		this.href = href;
	}

	private Integer id;
	private String href;
	private String name;
	private Uname uname;
	private String groups;
	private String isPublic;
	private String vlan;
	private Links.Link link;


	public String getGroups ()
	{
		return groups;
	}

	public void setGroups ( String groups )
	{
		this.groups = groups;
	}
	@XmlElement (name="public")
	public String getIsPublic ()
	{
		return isPublic;
	}

	public void setIsPublic ( String isPublic )
	{
		this.isPublic = isPublic;
	}

	public String getVlan ()
	{
		return vlan;
	}

	public void setVlan ( String vlan )
	{
		this.vlan = vlan;
	}

	public Integer getId ()
	{
		return id;
	}

	public void setId ( Integer id )
	{
		this.id = id;
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
	@XmlAttribute (name = "name")
	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public Uname getUname ()
	{
		return uname;
	}

	public void setUname ( Uname uname )
	{
		this.uname = uname;
	}

	public Links.Link getLink ()
	{
		return link;
	}

	public void setLink ( Links.Link link )
	{
		this.link = link;
	}

	@Override public String toString ()
	{
		return "Network{" +
				"id=" + id +
				", href='" + href + '\'' +
				", name='" + name + '\'' +
				", uname='" + uname + '\'' +
				", groups='" + groups + '\'' +
				", isPublic='" + isPublic + '\'' +
				", vlan='" + vlan + '\'' +
				", link=" + link +
				'}';
	}
}
