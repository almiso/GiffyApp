package org.almiso.giffy.network.core.exceprion;


public class BadUrlException extends Exception {

    public BadUrlException(Exception exception) {
        super(exception.getMessage(), exception.getCause());
    }
}
