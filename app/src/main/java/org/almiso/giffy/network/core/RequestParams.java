package org.almiso.giffy.network.core;


import java.util.List;

public interface RequestParams {

    List<RequestParamsEntry> getParams();

    void putParam(String key, int value);

    void putParam(String key, long value);

    void putParam(String key, double value);

    void putParam(String key, float value);

    void putParam(String key, String value);
}
