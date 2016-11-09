package org.almiso.giffy.network.core.request;

/**
 * Base param entity.
 */
public interface NetworkRequestParamsEntry {

    /**
     * Returns the key of the param.
     */
    String getKey();

    /**
     * Returns the value of the param.
     */
    Object getValue();
}
