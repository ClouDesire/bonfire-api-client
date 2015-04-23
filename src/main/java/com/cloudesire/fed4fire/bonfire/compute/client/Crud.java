package com.cloudesire.fed4fire.bonfire.compute.client;


public interface Crud <T,A> extends Create<T>, Retrieve<T>, RetrieveAll<A>, Update<T>, Delete
{
}
