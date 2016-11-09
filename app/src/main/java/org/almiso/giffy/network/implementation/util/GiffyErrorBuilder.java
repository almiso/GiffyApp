package org.almiso.giffy.network.implementation.util;


import org.almiso.giffy.network.core.exceprion.BadUrlException;
import org.almiso.giffy.network.core.exceprion.HttpException;
import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.util.ErrorBuilder;
import org.almiso.giffy.network.implementation.error.BadUrlError;
import org.almiso.giffy.network.implementation.error.HttpError;
import org.almiso.giffy.network.implementation.error.ParseError;
import org.almiso.giffy.network.implementation.error.UnknownError;

public class GiffyErrorBuilder implements ErrorBuilder {

    private Throwable throwable;

    public GiffyErrorBuilder(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public JobError createError() {

        if (throwable instanceof ParseException) {
            return new ParseError((ParseException) throwable);
        }

        if (throwable instanceof HttpException) {
            return new HttpError((HttpException) throwable);
        }

        if (throwable instanceof BadUrlException) {
            return new BadUrlError((BadUrlException) throwable);
        }

        return new UnknownError(throwable);
    }
}
