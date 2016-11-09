package org.almiso.giffy.network.implementation.error;


import android.content.Context;
import android.support.annotation.NonNull;

import org.almiso.giffy.R;
import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.exceprion.HttpException;
import org.almiso.giffy.network.core.job.JobError;

import javax.inject.Inject;

public class HttpError implements JobError<HttpException> {

    @Inject
    Context context;

    private HttpException exception;

    public HttpError(@NonNull HttpException exception) {
        this.exception = exception;

        GiffyApplication.getComponentController().getAppComponent().inject(this);
    }

    @Override
    public String getErrorMessage() {
        return context.getString(R.string.st_error_http);
    }

    @Override
    public HttpException getException() {
        return exception;
    }
}
