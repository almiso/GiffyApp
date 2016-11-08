package org.almiso.giffy.network.core.client;

import org.almiso.giffy.network.core.parser.ParseException;

/**
 * Base server response.
 */
public interface ServerResponse<T> {

    /**
     * Returns the response.
     */
    T getResponse();

    /**
     * Returns the response in the String.
     */
    String getResponseString() throws ParseException;
}
