package org.almiso.giffy.network.sample;

/**
 * Provides access for API parts.
 */
public class GiffyApi {

    /**
     * Returns object for preparing requests to test part of API.
     */
    public static GiffyApiTest test() {
        return new GiffyApiTest();
    }
}
