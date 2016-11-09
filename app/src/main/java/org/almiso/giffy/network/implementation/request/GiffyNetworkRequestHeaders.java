package org.almiso.giffy.network.implementation.request;


import android.text.TextUtils;

import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestHeadersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GiffyNetworkRequestHeaders implements NetworkRequestHeaders {

    /* Data */

    private TreeMap<String, String> headers;

    /* Constructor */

    public GiffyNetworkRequestHeaders() {
        headers = new TreeMap<>();
    }

    /* Override methods */

    @Override
    public List<NetworkRequestHeadersEntity> getHeaders() {
        List<NetworkRequestHeadersEntity> entries = new ArrayList<>();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            NetworkRequestHeadersEntity item = new GiffyNetworkRequestHeadersEntity(entry.getKey(), entry.getValue());
            entries.add(item);
        }
        return entries;
    }

    @Override
    public void putHeader(String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            headers.put(key, value);
        }
    }
}
