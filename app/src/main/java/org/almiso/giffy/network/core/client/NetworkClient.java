package org.almiso.giffy.network.core.client;


import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.request.Request;

/**
 * Base network client.
 * Executes the {@link Request request}
 * and send result into the {@link ServerCallback callback}.
 */
public interface NetworkClient {

    /**
     * Executes the request.
     */
    void execute(@NonNull Request request, @NonNull ServerCallback callback);
}
