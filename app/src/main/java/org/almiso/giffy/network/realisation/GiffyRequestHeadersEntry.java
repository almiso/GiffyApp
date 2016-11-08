package org.almiso.giffy.network.realisation;

import org.almiso.giffy.network.core.RequestHeadersEntry;

public class GiffyRequestHeadersEntry implements RequestHeadersEntry {

    private String key;
    private String value;

    public GiffyRequestHeadersEntry(String key, String value) {
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
