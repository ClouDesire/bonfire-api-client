package com.cloudesire.fed4fire.bonfire.compute.client;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

public interface GetListenableFuture<T>
{
	ListenableFuture<T> getListenableFuture ( Integer entityId, long timeout, TimeUnit unit );

}
