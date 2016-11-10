package org.almiso.giffy.test.di.app;

import org.almiso.giffy.di.app.AppComponent;
import org.almiso.giffy.network.implementation.error.BadUrlError;
import org.almiso.giffy.network.implementation.error.HttpError;
import org.almiso.giffy.network.implementation.error.ParseError;
import org.almiso.giffy.network.implementation.error.UnknownError;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestAppModule.class})
public interface TestAppComponent  extends AppComponent {

    void inject(BadUrlError error);

    void inject(HttpError error);

    void inject(ParseError error);

    void inject(UnknownError error);
}
