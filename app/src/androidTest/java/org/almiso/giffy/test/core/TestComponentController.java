package org.almiso.giffy.test.core;


import org.almiso.giffy.core.ComponentController;
import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.di.app.AppComponent;
import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.di.network.NetworkComponent;
import org.almiso.giffy.test.di.app.DaggerTestAppComponent;
import org.almiso.giffy.test.di.app.DaggerTestNetworkComponent;
import org.almiso.giffy.test.di.app.DaggerTestRequestComponent;
import org.almiso.giffy.test.di.app.TestAppComponent;
import org.almiso.giffy.test.di.app.TestAppModule;
import org.almiso.giffy.test.di.app.TestNetworkComponent;
import org.almiso.giffy.test.di.app.TestRequestComponent;
import org.almiso.giffy.test.di.network.TestNetworkModule;
import org.almiso.giffy.test.di.network.TestRequestModule;

public class TestComponentController extends ComponentController {

    /* Data */

    private GiffyApplication application;

    private TestAppComponent appComponent;
    private TestNetworkComponent networkComponent;
    private TestRequestComponent requestComponent;

    /* Constructor */

    TestComponentController( GiffyApplication application) {
        super(application);
        this.application = application;
        org.almiso.giffy.di.app.AppModule a;
    }

    /* Initialisation methods */

    void init() {
        appComponent = createAppComponent();
        networkComponent = createNetworkComponent();
        requestComponent = createRequestComponent();
    }

    /* Create methods */

    private TestAppComponent createAppComponent() {
        return DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(application))
                .build();
    }

    private TestNetworkComponent createNetworkComponent() {
        return DaggerTestNetworkComponent.builder()
                .testNetworkModule(new TestNetworkModule())
                .build();
    }

    private TestRequestComponent createRequestComponent() {
        return requestComponent = DaggerTestRequestComponent.builder()
                .testRequestModule(new TestRequestModule())
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
