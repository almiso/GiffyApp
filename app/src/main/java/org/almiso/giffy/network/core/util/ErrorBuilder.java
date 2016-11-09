package org.almiso.giffy.network.core.util;


import org.almiso.giffy.network.core.job.JobError;

public interface ErrorBuilder {

    JobError createError();
}
