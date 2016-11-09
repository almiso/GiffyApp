package org.almiso.giffy.network.core.exceprion;


import java.io.IOException;

public class HttpException extends Exception {

    private IOException exception;

    public HttpException(IOException exception) {
        super(exception);
        this.exception = exception;
    }
}
