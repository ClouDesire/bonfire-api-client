package com.cloudesire.fed4fire.bonfire.compute.client;

import com.cloudesire.fed4fire.bonfire.compute.client.objects.Network;
import com.cloudesire.fed4fire.bonfire.compute.client.objects.Networks;

public interface NetworkClient extends RetrieveAll<Networks>, Retrieve<Network>, RetrieveByExperimentId<Networks>
{
}
