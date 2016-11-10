package org.almiso.giffy.core;


import org.almiso.giffy.di.app.AppComponent;
import org.almiso.giffy.di.app.AppModule;
import org.almiso.giffy.di.app.DaggerAppComponent;
import org.almiso.giffy.di.client.DaggerRequestComponent;
import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.di.client.RequestModule;
import org.almiso.giffy.di.network.DaggerNetworkComponent;
import org.almiso.giffy.di.network.NetworkComponent;
import org.almiso.giffy.di.network.NetworkModule;

public class ComponentController {

    /* Data */

    private GiffyApplication application;

    private AppComponent appComponent;
    private NetworkComponent networkComponent;
    private RequestComponent requestComponent;

    /* Constructor */

    public ComponentController(GiffyApplication application) {
        this.application = application;
    }

    /* Initialisation methods */

    void init() {
        appComponent = createAppComponent();
        networkComponent = createNetworkComponent();
        requestComponent = createRequestComponent();
    }

    /* Create methods */

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    private NetworkComponent createNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule())
                .build();
    }

    private RequestComponent createRequestComponent() {
        return requestComponent = DaggerRequestComponent.builder()
                .requestModule(new RequestModule())
                .build();
    }

    /* Getters */

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    public RequestComponent getRequestComponent() {
        return requestComponent;
    }
}
