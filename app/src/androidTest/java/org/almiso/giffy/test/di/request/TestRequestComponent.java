package org.almiso.giffy.test.di.app;

import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.test.di.network.TestRequestModule;
import org.almiso.giffy.test.request.TestGetRandomJoke;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestRequestModule.class})
public interface TestRequestComponent extends RequestComponent {

    void inject(TestGetRandomJoke test);
}
