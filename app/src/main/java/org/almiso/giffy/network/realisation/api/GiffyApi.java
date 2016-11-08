package org.almiso.giffy.network.realisation.api;

import org.almiso.giffy.network.realisation.api.test.GiffyApiTest;

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
