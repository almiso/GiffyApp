package org.almiso.giffy.test.di.app;

import org.almiso.giffy.di.network.NetworkComponent;
import org.almiso.giffy.test.di.network.TestNetworkModule;
import org.almiso.giffy.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestNetworkModule.class})
public interface TestNetworkComponent extends NetworkComponent {
    void inject(MainActivity activity);
}
