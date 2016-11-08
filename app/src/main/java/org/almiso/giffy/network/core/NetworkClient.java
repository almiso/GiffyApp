package org.almiso.giffy.network.core;


import android.support.annotation.NonNull;

public interface NetworkClient {

    void execute(@NonNull NetworkRequest networkRequest, @NonNull ServerCallback callback);
}
