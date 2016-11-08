package org.almiso.giffy.network.core.task;


import android.support.annotation.NonNull;

/**
 * Callback for the task.
 */
public interface TaskCallback<T extends TaskResponse, V extends TaskError> {

    /**
     * Calls after the task finished with success.
     */
    void onSuccess(@NonNull T response);

    /**
     * Calls after the task finished with error.
     */
    void onError(@NonNull V error);
}
