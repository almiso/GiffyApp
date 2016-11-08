package org.almiso.giffy.network.core;


import android.support.annotation.NonNull;

public class EmptyRequestCallback implements RequestCallback {

    @Override
    public void onSuccess(@NonNull RequestResponse response) {
    }

    @Override
    public void onError(@NonNull RequestError error) {
    }
}
