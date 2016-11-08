package org.almiso.giffy.di.client;


import org.almiso.giffy.network.realisation.api.test.GetJokeForName;
import org.almiso.giffy.network.realisation.api.test.GetRandomJoke;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ClientModule.class})
public interface ClientComponent {

    void inject(GetRandomJoke request);

    void inject(GetJokeForName request2);
}
