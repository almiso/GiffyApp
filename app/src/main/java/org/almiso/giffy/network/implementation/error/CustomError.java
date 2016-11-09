package org.almiso.giffy.network.implementation.error;


import org.almiso.giffy.network.core.exceprion.CustomException;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.job.JobResponse;

public class CustomError implements JobError<CustomException> {

    private JobResponse response;
    private CustomException exception;

    public CustomError(JobResponse response) {
        this.exception = new CustomException();
        this.response = response;
    }

    @Override
    public String getErrorMessage() {
        return exception.getMessage();
    }

    @Override
    public CustomException getException() {
        return exception;
    }

    public JobResponse getResponse() {
        return response;
    }
}
