package org.almiso.giffy.network.core.client;


import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.request.NetworkRequest;

/**
 * Base network client.
 * Executes the {@link NetworkRequest request}
 * and send result into the {@link ServerCallback callback}.
 */
public interface NetworkClient {

    /**
     * Executes the networkRequest.
     */
    void execute(@NonNull NetworkRequest networkRequest, @NonNull ServerCallback callback);
}
