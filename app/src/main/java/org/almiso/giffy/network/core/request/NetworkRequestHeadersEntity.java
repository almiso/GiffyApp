package org.almiso.giffy.network.core.request;

/**
 * Base header entity.
 */
public interface NetworkRequestHeadersEntity {

    /**
     * Returns the key of the header.
     */
    String getKey();

    /**
     * Returns the value of the header.
     */
    String getValue();
}
