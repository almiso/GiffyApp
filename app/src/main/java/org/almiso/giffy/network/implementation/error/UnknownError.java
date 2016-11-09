package org.almiso.giffy.network.implementation.error;


import android.content.Context;
import android.support.annotation.NonNull;

import org.almiso.giffy.R;
import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.job.JobError;

import javax.inject.Inject;

public class UnknownError implements JobError<Throwable> {

    @Inject
    Context context;

    private Throwable throwable;

    public UnknownError(@NonNull Throwable throwable) {
        this.throwable = throwable;

        GiffyApplication.getAppComponent().inject(this);
    }

    @Override
    public String getErrorMessage() {
        return context.getString(R.string.st_error_unknown);
    }

    @Override
    public Throwable getException() {
        return throwable;
    }
}
