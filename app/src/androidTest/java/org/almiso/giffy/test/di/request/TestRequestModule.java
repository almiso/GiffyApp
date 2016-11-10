package org.almiso.giffy.test.di.network;

import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.client.ServerCallback;
import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequestHeaders;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequestParams;

import dagger.Module;
import dagger.Provides;

@Module
public class TestRequestModule {

    @Provides
    public NetworkClient providesNetworkClient() {
        return new NetworkClient() {
            @Override
            public void execute(@NonNull NetworkRequest networkRequest, @NonNull ServerCallback callback) {
                callback.onServerError(new Exception("Ahahahahahaah"));
            }
        };
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
