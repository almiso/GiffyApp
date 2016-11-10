package org.almiso.giffy.test.di.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestAppModule {

    private Context context;

    public TestAppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }
}
