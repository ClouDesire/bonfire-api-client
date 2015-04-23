package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement (name = "storage", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class Storage
{
	public static class DataStorageBuilder
	{
		private String name;
		private String description;
		private Integer size;

		public DataStorageBuilder setName( String name )
		{
			this.name = name;
			return this;
		}
		public DataStorageBuilder setDescription( String description )
		{
			this.description = description;
			return this;
		}
		public DataStorageBuilder setSize( Integer size )
		{
			this.size = size;
			return this;
		}
		public Storage build ()
		{
			if ( this.name == null || this.size == null )throw new IllegalArgumentException("Name and size are required");
			Storage storage = new Storage();
			storage.setName(name);
			storage.setDescription(description);
			storage.setSize(size);
			storage.setFsType("ext3");
			storage.setType("DATABLOCK");
			return storage;
		}

	}


	public Storage (){}
	public Storage ( String href )
	{
		this.href = href;
	}

	private Integer id;
	private String href;
	private String nameAttribute;
	private String name;
	private String groups;
	private String state;
	private String description;
	private String isPublic;
	private String user;
	private String userId;
	private String type;
	private Integer size;
	private String persistent;
	private String datastore;
	private String datastoreId;
	private Links.Link link;
	private String fsType;

	@XmlElement (name = "name")
	public String getName ()
	{
		return name;
	}

	public void setName ( String name )
	{
		this.name = name;
	}

	@XmlElement (name = "fstype")
	public String getFsType ()
	{
		return fsType;
	}

	public void setFsType ( String fsType )
	{
		this.fsType = fsType;
	}

	public Integer getId ()
	{
		return id;
	}

	public void setId ( Integer id )
	{
		this.id = id;
	}

	public String getGroups ()
	{
		return groups;
	}

	public void setGroups ( String groups )
	{
		this.groups = groups;
	}

	public String getState ()
	{
		return state;
	}

	public void setState ( String state )
	{
		this.state = state;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription ( String description )
	{
		this.description = description;
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

	public String getDatastore ()
	{
		return datastore;
	}

	public void setDatastore ( String datastore )
	{
		this.datastore = datastore;
	}
	@XmlElement (name="datastore_id")
	public String getDatastoreId ()
	{
		return datastoreId;
	}

	public void setDatastoreId ( String datastoreId )
	{
		this.datastoreId = datastoreId;
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

	public String getUser ()
	{
		return user;
	}

	public void setUser ( String user )
	{
		this.user = user;
	}
	@XmlElement (name="user_id")
	public String getUserId ()
	{
		return userId;
	}

	public void setUserId ( String userId )
	{
		this.userId = userId;
	}

	public String getType ()
	{
		return type;
	}

	public void setType ( String type )
	{
		this.type = type;
	}

	public Integer getSize ()
	{
		return size;
	}

	public void setSize ( Integer size )
	{
		this.size = size;
	}

	public String getPersistent ()
	{
		return persistent;
	}

	public void setPersistent ( String persistent )
	{
		this.persistent = persistent;
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
		return "Storage{" +
				"id=" + id +
				", href='" + href + '\'' +
				", nameAttribute='" + nameAttribute + '\'' +
				", groups='" + groups + '\'' +
				", state='" + state + '\'' +
				", description='" + description + '\'' +
				", isPublic='" + isPublic + '\'' +
				", user='" + user + '\'' +
				", userId='" + userId + '\'' +
				", type='" + type + '\'' +
				", size=" + size +
				", persistent='" + persistent + '\'' +
				", datastore='" + datastore + '\'' +
				", datastoreId='" + datastoreId + '\'' +
				", link=" + link +
				'}';
	}
}
