package org.almiso.giffy.network.implementation.error;


import android.content.Context;
import android.support.annotation.NonNull;

import org.almiso.giffy.R;
import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.job.JobError;

import javax.inject.Inject;

public class ParseError implements JobError<ParseException> {

    @Inject
    Context context;

    private ParseException exception;

    public ParseError(@NonNull ParseException exception) {
        this.exception = exception;

        GiffyApplication.getAppComponent().inject(this);
    }

    @Override
    public String getErrorMessage() {
        return context.getString(R.string.st_error_parse);
    }

    @Override
    public ParseException getException() {
        return exception;
    }
}
