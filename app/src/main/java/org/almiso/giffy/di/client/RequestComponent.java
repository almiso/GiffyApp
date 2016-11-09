package org.almiso.giffy.di.client;


import org.almiso.giffy.network.implementation.api.test.GetJokeForName;
import org.almiso.giffy.network.implementation.api.test.GetRandomJoke;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RequestModule.class})
public interface RequestComponent {

    void inject(GetRandomJoke request);

    void inject(GetJokeForName request);
}