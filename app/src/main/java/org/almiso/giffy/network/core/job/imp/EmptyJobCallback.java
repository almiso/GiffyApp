package org.almiso.giffy.network.core.job.imp;

import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.job.JobCallback;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.job.JobResponse;

/**
 * Default realisation of the {@link JobCallback JobCallback}.
 */
public class EmptyJobCallback implements JobCallback {

    @Override
    public void onSuccess(@NonNull JobResponse response) {
    }

    @Override
    public void onError(@NonNull JobError error) {
    }
}
