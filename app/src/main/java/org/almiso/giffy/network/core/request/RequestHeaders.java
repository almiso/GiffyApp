package org.almiso.giffy.network.core.request;


import java.util.List;

/**
 * Network request headers.
 */
public interface RequestHeaders {

    /**
     * Returns the list of headers.
     */
    List<RequestHeadersEntity> getHeaders();

    /**
     * Add header.
     */
    void putHeader(String key, String value);
}
