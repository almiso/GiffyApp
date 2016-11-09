package org.almiso.giffy.network.core.request.imp;

import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestHeadersEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Default realisation of the {@link NetworkRequestHeaders NetworkRequestHeaders}.
 */
public class EmptyNetworkRequestHeaders implements NetworkRequestHeaders {

    @Override
    public List<NetworkRequestHeadersEntity> getHeaders() {
        return new ArrayList<>();
    }

    @Override
    public void putHeader(String key, String value) {
    }
}
