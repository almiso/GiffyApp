package org.almiso.giffy.network.core.request.imp;

import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestParamsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Default realisation of the {@link NetworkRequestParams NetworkRequestParams}.
 */
public class EmptyNetworkRequestParams implements NetworkRequestParams {

    @Override
    public List<NetworkRequestParamsEntry> getParams() {
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
