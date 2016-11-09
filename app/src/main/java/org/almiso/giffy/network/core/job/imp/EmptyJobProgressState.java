package org.almiso.giffy.network.core.job.imp;

import org.almiso.giffy.network.core.job.JobProgressState;

/**
 * Default realisation of the {@link JobProgressState JobProgressState}.
 */
public class EmptyJobProgressState implements JobProgressState {

    @Override
    public void onStart() {
    }

    @Override
    public void onFinish() {
    }
}
