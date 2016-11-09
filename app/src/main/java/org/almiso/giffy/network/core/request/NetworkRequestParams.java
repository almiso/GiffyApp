package org.almiso.giffy.network.core.request;

import java.util.List;

/**
 * Network request params.
 */
public interface NetworkRequestParams {

    /**
     * Returns the list of params.
     */
    List<NetworkRequestParamsEntry> getParams();

    /**
     * Add param for type int.
     */
    void putParam(String key, int value);

    /**
     * Add param for type long.
     */
    void putParam(String key, long value);

    /**
     * Add param for type double.
     */
    void putParam(String key, double value);

    /**
     * Add param for type float.
     */
    void putParam(String key, float value);

    /**
     * Add param for type String.
     */
    void putParam(String key, String value);
}
