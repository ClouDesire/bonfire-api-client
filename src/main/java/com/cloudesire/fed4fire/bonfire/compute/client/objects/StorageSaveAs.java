package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement (name = "compute", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class StorageSaveAs
{
	public StorageSaveAs (){}

	public StorageSaveAs ( String saveAs )
	{
		this( null, saveAs );
	}

	public StorageSaveAs ( Integer diskId, String saveAs )
	{
		this.disk=new Compute.Disk( diskId !=null ? diskId : 0 );
		disk.setSaveAs(new Compute.SaveAs(saveAs));
	}

	Compute.Disk disk;

	public Compute.Disk getDisk ()
	{
		return disk;
	}

	public void setDisk ( Compute.Disk disk )
	{
		this.disk = disk;
	}
}
