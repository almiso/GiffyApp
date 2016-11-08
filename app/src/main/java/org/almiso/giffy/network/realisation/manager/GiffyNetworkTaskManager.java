package org.almiso.giffy.network.realisation.manager;


import org.almiso.giffy.network.core.task.Task;
import org.almiso.giffy.network.core.task.TaskIdentifier;
import org.almiso.giffy.network.core.manager.TaskManager;

public class GiffyNetworkTaskManager implements TaskManager {

    /* Constructor */

    public GiffyNetworkTaskManager() {

    }

    /* Override methods */

    @Override
    public void executeTask(final Task task) {
        switch (task.getTaskType()) {
            case SYNCHRONOUS:
                runSynchronousTask(task);
                break;

            case ASYNCHRONOUS:
                runAsynchronousTask(task);
                break;
        }
    }

    @Override
    public void cancelTask(TaskIdentifier identifier) {

    }

    /* Private  methods */

    private void runSynchronousTask(final Task task) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        }).start();
    }

    private void runAsynchronousTask(final Task task) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        }).start();
    }
}
