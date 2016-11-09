package org.almiso.giffy.network.core.manager;

import org.almiso.giffy.network.core.job.JobIdentifier;
import org.almiso.giffy.network.core.job.Job;

/**
 * Base task manager.
 * Manage queues of tasks.
 */
public interface JobManager {

    /**
     * Puts job to the queue.
     */
    void addToQueue(final Job job);

    /**
     * Cancels task and remove it from the queue.
     */
    void removeFromQueue(JobIdentifier identifier);
}
