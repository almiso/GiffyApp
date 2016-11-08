package org.almiso.giffy.network.core;


public interface ServerCallback {

    void onServerSuccess(ServerResponse response);

    void onServerError(Throwable throwable);
}
