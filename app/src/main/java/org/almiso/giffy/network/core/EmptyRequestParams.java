package org.almiso.giffy.network.core;


import java.util.ArrayList;
import java.util.List;

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
