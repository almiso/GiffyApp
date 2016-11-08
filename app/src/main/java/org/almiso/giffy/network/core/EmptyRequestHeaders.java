package org.almiso.giffy.network.core;


import java.util.ArrayList;
import java.util.List;

public class EmptyRequestHeaders implements RequestHeaders{

    @Override
    public List<RequestHeadersEntry> getHeaders() {
        return new ArrayList<>();
    }

    @Override
    public void putHeader(String key, String value) {
    }
}
