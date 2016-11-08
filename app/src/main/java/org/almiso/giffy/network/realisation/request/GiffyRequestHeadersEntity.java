package org.almiso.giffy.network.realisation.request;

import org.almiso.giffy.network.core.request.RequestHeadersEntity;

public class GiffyRequestHeadersEntity implements RequestHeadersEntity {

    private String key;
    private String value;

    public GiffyRequestHeadersEntity(String key, String value) {
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
