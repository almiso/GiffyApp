package org.almiso.giffy.di.network;


import org.almiso.giffy.network.core.TaskManager;
import org.almiso.giffy.network.realisation.GiffyNetworkTaskManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    TaskManager providesTaskManager() {
        return new GiffyNetworkTaskManager();
    }
}
