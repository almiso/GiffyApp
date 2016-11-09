package org.almiso.giffy.network.core.job;


import android.support.annotation.NonNull;

/**
 * Base task class.
 * Can be network, DB or ect task.
 * Runs in background thread.
 */
public interface Job {

    /**
     * Returns the identifier of the current task.
     */
    JobIdentifier getIdentifier();

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
    void setCallback(@NonNull JobCallback jobCallback);

    /**
     * Sets tha tasks progress interface.
     */
    void setJobProgressState(@NonNull JobProgressState jobProgressState);

    /**
     * Returns the task type.
     */
    JobType getJobType();
}
