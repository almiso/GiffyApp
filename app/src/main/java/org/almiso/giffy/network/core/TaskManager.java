package org.almiso.giffy.network.core;


public interface TaskManager {

    void executeTask(final Task task);

    void cancelTask(TaskIdentifier identifier);
}
