package org.almiso.giffy.network.core;


import android.support.annotation.NonNull;

public interface RequestCallback<T extends RequestResponse, V extends RequestError> {

    void onSuccess(@NonNull T response);

    void onError(@NonNull V error);
}
