package org.almiso.giffy.network.core.exceprion;

/**
 * Base parse error.
 */
public class ParseException extends Exception {

    private Exception exception;

    public ParseException(Exception exception) {
        super(exception);
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
