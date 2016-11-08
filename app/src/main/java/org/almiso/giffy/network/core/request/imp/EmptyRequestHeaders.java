package org.almiso.giffy.network.core.request.imp;

import org.almiso.giffy.network.core.request.RequestHeaders;
import org.almiso.giffy.network.core.request.RequestHeadersEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Default realisation of the {@link RequestHeaders RequestHeaders}.
 */
public class EmptyRequestHeaders implements RequestHeaders {

    @Override
    public List<RequestHeadersEntity> getHeaders() {
        return new ArrayList<>();
    }

    @Override
    public void putHeader(String key, String value) {
    }
}
