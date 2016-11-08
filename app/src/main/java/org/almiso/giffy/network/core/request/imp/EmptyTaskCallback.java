package org.almiso.giffy.network.core.request.imp;

import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.task.TaskError;
import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.core.task.TaskCallback;

/**
 * Default realisation of the {@link TaskCallback TaskCallback}.
 */
public class EmptyTaskCallback implements TaskCallback {

    @Override
    public void onSuccess(@NonNull TaskResponse response) {
    }

    @Override
    public void onError(@NonNull TaskError error) {
    }
}
