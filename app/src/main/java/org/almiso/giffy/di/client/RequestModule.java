package org.almiso.giffy.di.client;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.implementation.client.GiffyNetworkClient;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequestParams;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequestHeaders;

import dagger.Module;
import dagger.Provides;

@Module
public class RequestModule {

    @Provides
    NetworkClient providesNetworkClient() {
        return new GiffyNetworkClient();
    }

    @Provides
    NetworkRequestParams provideRequestParams() {
        return new GiffyNetworkRequestParams();
    }

    @Provides
    NetworkRequestHeaders provideRequestHeaders() {
        return new GiffyNetworkRequestHeaders();
    }
}
