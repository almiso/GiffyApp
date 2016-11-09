package org.almiso.giffy.network.core.request;


import java.util.List;

/**
 * Network request headers.
 */
public interface NetworkRequestHeaders {

    /**
     * Returns the list of headers.
     */
    List<NetworkRequestHeadersEntity> getHeaders();

    /**
     * Add header.
     */
    void putHeader(String key, String value);
}
