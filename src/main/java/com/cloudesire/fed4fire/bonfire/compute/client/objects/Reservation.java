package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@XmlType
@XmlRootElement (name = "reservation", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Reservation
{
	public Reservation (){}
	public Reservation ( String href )
	{
		this.href = href;
	}
	public Reservation ( Integer id )
	{
		this.href = "/reservations/" + id;
	}

	private Integer id;
	private String href;
	private String status;
	private String user;
	private String groups;
	private String name;
	private String description;
	private Integer walltime;
	private Date startTime;

	private List<? extends Resource> resources = new LinkedList<>();


	@XmlAttribute (name = "href")
	public String getHref ()
	{
		return href;
	}

	public void setHref ( String href )
	{
		this.href = href;
	}

	public String getGroups ()
	{
		return groups;
	}

	public void setGroups ( String groups )
	{
		this.groups = groups;
	}

	public List<? extends Resource> getResources ()
	{
		return resources;
	}

	public void setResources ( List<? extends Resource> resources )
	{
		this.resources = resources;
	}

	@XmlElement (name = "starttime")
	public Date getStartTime ()
	{
		return startTime;
	}

	public void setStartTime ( Date startTime )
	{
		this.startTime = startTime;
	}

	public Integer getId ()
	{
		return id;
	}

	public void setId ( Integer id )
	{
		this.id = id;
	}

	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription ( String description )
	{
		this.description = description;
	}

	public Integer getWalltime ()
	{
		return walltime;
	}

	public void setWalltime ( Integer walltime )
	{
		this.walltime = walltime;
	}

	public String getUser ()
	{
		return user;
	}

	public void setUser ( String user )
	{
		this.user = user;
	}

	public String getStatus ()
	{
		return status;
	}

	public void setStatus ( String status )
	{
		this.status = status;
	}

	@Override public String toString ()
	{
		return  "id=" + id +
				", href='" + href + '\'' +
				", status='" + status + '\'' +
				", user='" + user + '\'' +
				", groups='" + groups + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", walltime=" + walltime +
				", startTime=" + startTime +
				", resources=" + resources;
	}
}
