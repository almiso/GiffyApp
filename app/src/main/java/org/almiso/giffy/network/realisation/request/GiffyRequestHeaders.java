package org.almiso.giffy.network.realisation.request;


import android.text.TextUtils;

import org.almiso.giffy.network.core.request.RequestHeaders;
import org.almiso.giffy.network.core.request.RequestHeadersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GiffyRequestHeaders implements RequestHeaders {

    /* Data */

    private TreeMap<String, String> headers;

    /* Constructor */

    public GiffyRequestHeaders() {
        headers = new TreeMap<>();
    }

    /* Override methods */

    @Override
    public List<RequestHeadersEntity> getHeaders() {
        List<RequestHeadersEntity> entries = new ArrayList<>();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            RequestHeadersEntity item = new GiffyRequestHeadersEntity(entry.getKey(), entry.getValue());
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
