package org.almiso.giffy.core;


import android.app.Application;

import org.almiso.giffy.di.app.AppComponent;
import org.almiso.giffy.di.app.AppModule;
import org.almiso.giffy.di.app.DaggerAppComponent;
import org.almiso.giffy.di.client.DaggerRequestComponent;
import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.di.client.RequestModule;
import org.almiso.giffy.di.network.DaggerNetworkComponent;
import org.almiso.giffy.di.network.NetworkComponent;
import org.almiso.giffy.di.network.NetworkModule;

public class GiffyApplication extends Application {

    private static AppComponent appComponent;
    private static NetworkComponent networkComponent;
    private static RequestComponent requestComponent;

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

    public static RequestComponent getRequestComponent() {
        if (requestComponent == null) {
            requestComponent = DaggerRequestComponent.builder()
                    .requestModule(new RequestModule())
                    .build();
        }
        return requestComponent;
    }
}
