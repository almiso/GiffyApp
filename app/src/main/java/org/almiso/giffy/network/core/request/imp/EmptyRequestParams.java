package org.almiso.giffy.network.core.request.imp;

import org.almiso.giffy.network.core.request.RequestParams;
import org.almiso.giffy.network.core.request.RequestParamsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Default realisation of the {@link RequestParams RequestParams}.
 */
public class EmptyRequestParams implements RequestParams {

    @Override
    public List<RequestParamsEntry> getParams() {
        return new ArrayList<>();
    }

    @Override
    public void putParam(String key, int value) {
    }

    @Override
    public void putParam(String key, long value) {
    }

    @Override
    public void putParam(String key, double value) {
    }

    @Override
    public void putParam(String key, float value) {
    }

    @Override
    public void putParam(String key, String value) {
    }
}
