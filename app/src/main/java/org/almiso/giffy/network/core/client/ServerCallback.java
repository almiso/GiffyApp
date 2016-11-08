package org.almiso.giffy.network.core.client;

/**
 * Base server callback.
 */
public interface ServerCallback {

    /**
     * Calls after the request finished with success.
     */
    void onServerSuccess(ServerResponse response);

    /**
     * Calls after the request finished with error.
     */
    void onServerError(Throwable throwable);
}
