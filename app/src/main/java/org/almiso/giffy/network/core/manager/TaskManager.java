package org.almiso.giffy.network.core.manager;

import org.almiso.giffy.network.core.task.TaskIdentifier;
import org.almiso.giffy.network.core.task.Task;

/**
 * Base task manager.
 * Manage queues of tasks.
 */
public interface TaskManager {

    /**
     * Puts task to the queue.
     */
    void executeTask(final Task task);

    /**
     * Cancels task and remove it from the queue.
     */
    void cancelTask(TaskIdentifier identifier);
}
