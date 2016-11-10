package org.almiso.giffy.test.di.network;

import org.almiso.giffy.network.core.manager.JobManager;
import org.almiso.giffy.network.implementation.manager.GiffyNetworkJobManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestNetworkModule {

    @Provides
    @Singleton
    JobManager providesTaskManager() {
        return new GiffyNetworkJobManager();
    }
}
