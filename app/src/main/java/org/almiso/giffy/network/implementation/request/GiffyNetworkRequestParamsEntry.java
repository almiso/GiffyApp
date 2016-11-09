package org.almiso.giffy.network.implementation.request;


import org.almiso.giffy.network.core.request.NetworkRequestParamsEntry;

public class GiffyNetworkRequestParamsEntry implements NetworkRequestParamsEntry {

    private String key;
    private Object value;

    public GiffyNetworkRequestParamsEntry(String key, Object value) {
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
