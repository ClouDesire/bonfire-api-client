package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlType
@XmlRootElement (name = "experiment", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Experiment extends Links
{
	private Integer id;
	//private Reservation reservation;
	private Integer reservationId;
	private String name;
	private String description;
	private Integer walltime;
	private Integer userId;
	private String status;
	private String href;
	private String groups;
	private String routingKey;
	private String aggregatorPassword;
	private Date createdAt;
	private Date updatedAt;
	private List<Network> networks;
	private List<Compute> computes;
	private List<Storage> storages;

	@XmlElement (name = "reservation")
	public Integer getReservationId ()
	{
		return reservationId;
	}

	public void setReservationId ( Integer reservationId )
	{
		this.reservationId = reservationId;
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

	public String getGroups ()
	{
		return groups;
	}

	public void setGroups ( String groups )
	{
		this.groups = groups;
	}
	@XmlElement (name = "routing_key")
	public String getRoutingKey ()
	{
		return routingKey;
	}

	public void setRoutingKey ( String routingKey )
	{
		this.routingKey = routingKey;
	}
	@XmlElement (name = "aggregator_password")
	public String getAggregatorPassword ()
	{
		return aggregatorPassword;
	}

	public void setAggregatorPassword ( String aggregatorPassword )
	{
		this.aggregatorPassword = aggregatorPassword;
	}
	@XmlElement (name = "created_at")
	public Date getCreatedAt ()
	{
		return createdAt;
	}

	public void setCreatedAt ( Date createdAt )
	{
		this.createdAt = createdAt;
	}
	@XmlElement (name = "updated_at")
	public Date getUpdatedAt ()
	{
		return updatedAt;
	}

	public void setUpdatedAt ( Date updatedAt )
	{
		this.updatedAt = updatedAt;
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

	@XmlElement (name = "user_id")
	public Integer getUserId ()
	{
		return userId;
	}

	public void setUserId ( Integer userId )
	{
		this.userId = userId;
	}

	public String getStatus ()
	{
		return status;
	}

	public void setStatus ( String status )
	{
		this.status = status;
	}

	@XmlElement (name = "network")
	public List<Network> getNetworks ()
	{
		return networks;
	}

	public void setNetworks ( List<Network> networks )
	{
		this.networks = networks;
	}
	@XmlElement (name = "compute")
	public List<Compute> getComputes ()
	{
		return computes;
	}

	public void setComputes ( List<Compute> computes )
	{
		this.computes = computes;
	}

	@XmlElement (name = "storage")
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
		return "Experiment{" +
				"id=" + id +
				", name='" + name + '\'' +
				", reservationId=" + reservationId +
				", description='" + description + '\'' +
				", walltime=" + walltime +
				", userId=" + userId +
				", status='" + status + '\'' +
				", href='" + href + '\'' +
				", groups='" + groups + '\'' +
				", routingKey='" + routingKey + '\'' +
				", aggregatorPassword='" + aggregatorPassword + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", networks=" + networks +
				", computes=" + computes +
				", storages=" + storages +
				super.toString() +
				'}';
	}
}
