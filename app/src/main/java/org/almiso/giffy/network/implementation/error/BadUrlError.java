package org.almiso.giffy.network.implementation.error;


import android.content.Context;
import android.support.annotation.NonNull;

import org.almiso.giffy.R;
import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.exceprion.BadUrlException;
import org.almiso.giffy.network.core.job.JobError;

import javax.inject.Inject;

public class BadUrlError implements JobError<BadUrlException> {

    @Inject
    Context context;

    private BadUrlException exception;

    public BadUrlError(@NonNull BadUrlException exception) {
        this.exception = exception;

        GiffyApplication.getAppComponent().inject(this);
    }

    @Override
    public String getErrorMessage() {
        return context.getString(R.string.st_error_bad_url);
    }

    @Override
    public BadUrlException getException() {
        return exception;
    }
}
