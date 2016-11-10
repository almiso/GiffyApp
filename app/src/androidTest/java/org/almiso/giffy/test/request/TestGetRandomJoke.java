package org.almiso.giffy.test.request;

import android.support.test.runner.AndroidJUnit4;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.client.ServerCallback;
import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.implementation.api.test.GetRandomJoke;
import org.almiso.giffy.test.core.TestGiffyApplication;
import org.almiso.giffy.test.di.app.TestRequestComponent;
import org.almiso.giffy.utils.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TestGetRandomJoke {

    /* Constants */

    private static final String TAG = TestGetRandomJoke.class.getSimpleName();

    /* Data */

    private Throwable throwable;

    @Inject
    NetworkClient networkClient;

    @Before
    public void setUp() {
        ((TestRequestComponent) TestGiffyApplication.getComponentController().getRequestComponent()).inject(this);
    }

    /* Tests */

    @Test
    public void testNetworkClient() {
        Exception exception = new Exception("Ahahahahahaah");

        networkClient.execute(new GetRandomJoke(), new ServerCallback() {

            @Override
            public void onServerSuccess(ServerResponse response) {
                Logger.d(TAG, "response: " + response);
            }

            @Override
            public void onServerError(Throwable throwable1) {
                Logger.d(TAG, "throwable: " + throwable);
                throwable = throwable1;
            }
        });

        assertEquals(exception.getMessage(), throwable.getMessage());
    }
}
