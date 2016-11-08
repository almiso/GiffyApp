package org.almiso.giffy;


import android.app.Application;

import org.almiso.giffy.di.app.AppComponent;
import org.almiso.giffy.di.app.AppModule;
import org.almiso.giffy.di.app.DaggerAppComponent;
import org.almiso.giffy.di.network.DaggerNetworkComponent;
import org.almiso.giffy.di.network.NetworkComponent;
import org.almiso.giffy.di.network.NetworkModule;

public class App extends Application {

    private static AppComponent appComponent;
    private static NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(App.this))
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

}
