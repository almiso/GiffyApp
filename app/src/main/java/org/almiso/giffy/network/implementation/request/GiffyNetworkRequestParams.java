package org.almiso.giffy.network.implementation.request;


import android.text.TextUtils;

import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestParamsEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GiffyNetworkRequestParams implements NetworkRequestParams {

    private TreeMap<String, Object> params;

    public GiffyNetworkRequestParams() {
        params = new TreeMap<>();
    }

    @Override
    public List<NetworkRequestParamsEntry> getParams() {
        List<NetworkRequestParamsEntry> entries = new ArrayList<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            NetworkRequestParamsEntry item = new GiffyNetworkRequestParamsEntry(entry.getKey(), entry.getValue());
            entries.add(item);
        }
        return entries;
    }

    @Override
    public void putParam(String key, int value) {
        if (value > 0) {
            params.put(key, value);
        }
    }

    @Override
    public void putParam(String key, long value) {
        if (value > 0) {
            params.put(key, value);
        }
    }

    @Override
    public void putParam(String key, double value) {
        if (value > 0) {
            params.put(key, value);
        }
    }

    @Override
    public void putParam(String key, float value) {
        if (value > 0) {
            params.put(key, value);
        }
    }

    @Override
    public void putParam(String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            params.put(key, value);
        }
    }
}
