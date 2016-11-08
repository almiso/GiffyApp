package org.almiso.giffy.network.realisation;


import android.text.TextUtils;

import org.almiso.giffy.network.core.RequestParams;
import org.almiso.giffy.network.core.RequestParamsEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GiffyRequestParams implements RequestParams {

    private TreeMap<String, Object> params;

    public GiffyRequestParams() {
        params = new TreeMap<>();
    }

    @Override
    public List<RequestParamsEntry> getParams() {
        List<RequestParamsEntry> entries = new ArrayList<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            RequestParamsEntry item = new GiffyRequestParamsEntry(entry.getKey(), entry.getValue());
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
