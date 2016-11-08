package org.almiso.giffy.network.core.task;


import android.support.annotation.NonNull;

/**
 * Base task class.
 * Can be network, DB or ect task.
 * Runs in background thread.
 */
public interface Task {

    /**
     * Returns the identifier of the current task.
     */
    TaskIdentifier getIdentifier();

    /**
     * Starts executing of the current task.
     */
    void execute();

    /**
     * Cancels executing of the current task.
     */
    void cancel();

    /**
     * Sets callback for the task.
     */
    void setCallback(@NonNull TaskCallback taskCallback);

    /**
     * Sets tha tasks progress interface.
     */
    void setProgressInterface(@NonNull TaskProgressInterface taskProgressInterface);

    /**
     * Returns the task type.
     */
    TaskType getTaskType();
}
