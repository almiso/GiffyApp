package org.almiso.giffy.network.core.job;


import android.support.annotation.NonNull;

/**
 * Callback for the task.
 */
public interface JobCallback<T extends JobResponse, V extends JobError> {

    /**
     * Calls after the task finished with success.
     */
    void onSuccess(@NonNull T response);

    /**
     * Calls after the task finished with error.
     */
    void onError(@NonNull V error);
}
