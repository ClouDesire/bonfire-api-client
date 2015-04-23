package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.google.common.util.concurrent.SettableFuture;

import java.util.TimerTask;

public abstract class BaseCheckerTask<T> extends TimerTask
{
	protected final SettableFuture<T> result;
	protected final long end;
	protected final Integer entityId;

	protected BaseCheckerTask(Integer entityId, SettableFuture<T> result, long end)
	{
		this.entityId=entityId;
		this.result = result;
		this.end = end;
	}

}
