package org.almiso.giffy.network.realisation.request;


import org.almiso.giffy.network.core.request.RequestParamsEntry;

public class GiffyRequestParamsEntry implements RequestParamsEntry {

    private String key;
    private Object value;

    public GiffyRequestParamsEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
