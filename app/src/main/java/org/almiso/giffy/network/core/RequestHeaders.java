package org.almiso.giffy.network.core;


import java.util.List;

public interface RequestHeaders {

    List<RequestHeadersEntry> getHeaders();

    void putHeader(String key, String value);

}
