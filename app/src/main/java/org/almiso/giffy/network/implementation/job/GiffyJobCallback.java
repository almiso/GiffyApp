package org.almiso.giffy.network.implementation.job;

import org.almiso.giffy.network.core.job.JobCallback;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.job.JobResponse;

public abstract class GiffyJobCallback<T extends JobResponse> implements JobCallback<T, JobError> {
}
