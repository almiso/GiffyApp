package org.almiso.giffy.network.realisation;


import org.almiso.giffy.network.core.RequestParamsEntry;

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
