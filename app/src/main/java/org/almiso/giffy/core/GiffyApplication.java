package org.almiso.giffy.core;


import android.app.Application;

import org.almiso.giffy.di.app.AppComponent;
import org.almiso.giffy.di.app.AppModule;
import org.almiso.giffy.di.app.DaggerAppComponent;
import org.almiso.giffy.di.client.ClientComponent;
import org.almiso.giffy.di.client.ClientModule;
import org.almiso.giffy.di.client.DaggerClientComponent;
import org.almiso.giffy.di.network.DaggerNetworkComponent;
import org.almiso.giffy.di.network.NetworkComponent;
import org.almiso.giffy.di.network.NetworkModule;

public class GiffyApplication extends Application {

    private static AppComponent appComponent;
    private static NetworkComponent networkComponent;
    private static ClientComponent clientComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(GiffyApplication.this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static NetworkComponent getNetworkComponent() {
        if (networkComponent == null) {
            networkComponent = DaggerNetworkComponent.builder()
                    .networkModule(new NetworkModule())
                    .build();
        }
        return networkComponent;
    }

    public static ClientComponent getClientComponent() {
        if (clientComponent == null) {
            clientComponent = DaggerClientComponent.builder()
                    .clientModule(new ClientModule())
                    .build();
        }
        return clientComponent;
    }
}
