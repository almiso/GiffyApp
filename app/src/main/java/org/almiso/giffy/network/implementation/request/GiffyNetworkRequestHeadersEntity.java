package org.almiso.giffy.network.implementation.request;

import org.almiso.giffy.network.core.request.NetworkRequestHeadersEntity;

public class GiffyNetworkRequestHeadersEntity implements NetworkRequestHeadersEntity {

    private String key;
    private String value;

    public GiffyNetworkRequestHeadersEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
