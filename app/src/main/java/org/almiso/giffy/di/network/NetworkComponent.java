package org.almiso.giffy.di.network;

import org.almiso.giffy.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={NetworkModule.class})
public interface NetworkComponent {
    void inject(MainActivity activity);
}
