package com.cloudesire.fed4fire.bonfire.compute.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement (name = "compute", namespace = "http://api.bonfire-project.eu/doc/schemas/occi")
@XmlAccessorType (value = XmlAccessType.PROPERTY)
public class ComputeState
{
	public static enum State
	{
		SHUTDOWN, SUSPENDED, STOPPED, CANCEL, RESUME;
	}

	public ComputeState (){}

	public ComputeState ( State state )
	{
		this.state = state;
	}

	private State state;

	public State getState ()
	{
		return state;
	}

	public void setState ( State state )
	{
		this.state = state;
	}
}
