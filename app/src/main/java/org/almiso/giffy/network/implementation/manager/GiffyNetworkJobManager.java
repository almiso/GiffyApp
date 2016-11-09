package org.almiso.giffy.network.implementation.manager;


import org.almiso.giffy.network.core.manager.JobManager;
import org.almiso.giffy.network.core.job.Job;
import org.almiso.giffy.network.core.job.JobIdentifier;

public class GiffyNetworkJobManager implements JobManager {

    /* Constructor */

    public GiffyNetworkJobManager() {

    }

    /* Override methods */

    @Override
    public void addToQueue(final Job job) {

        switch (job.getJobType()) {
            case SYNCHRONOUS:
            case SIGN:
                runSynchronousTask(job);
                break;

            case ASYNCHRONOUS:
            case UNSIGN:
                runAsynchronousTask(job);
                break;
        }
    }

    @Override
    public void removeFromQueue(JobIdentifier identifier) {

    }

    /* Private  methods */

    private void runSynchronousTask(final Job job) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                job.execute();
            }
        }).start();
    }

    private void runAsynchronousTask(final Job job) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                job.execute();
            }
        }).start();
    }
}
