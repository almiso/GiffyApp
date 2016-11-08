package org.almiso.giffy.di.client;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.realisation.client.GiffyNetworkClient;

import dagger.Module;
import dagger.Provides;

@Module
public class ClientModule {

    @Provides
    NetworkClient providesNetworkClient() {
        return new GiffyNetworkClient();
    }
}
