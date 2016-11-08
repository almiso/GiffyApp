package org.almiso.giffy.network.core;


public interface ServerResponse<T> {

    T getResponse();

    String getResponseString() throws ParseException;
}
