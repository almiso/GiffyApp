package org.almiso.giffy.network.implementation.job;


import org.almiso.giffy.network.core.job.JobError;

public class GiffyError implements JobError {

    @Override
    public String getErrorMessage() {
        return "Error";
    }
}
