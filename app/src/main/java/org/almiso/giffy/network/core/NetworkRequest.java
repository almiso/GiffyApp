package org.almiso.giffy.network.core;

public interface NetworkRequest extends Task {

    RequestPath getRequestPath();

    RequestParams getParams();

    RequestHeaders getHeaders();

    NetworkClient getClient();

    RequestType getRequestType();

    Class<? extends RequestResponse> getResponseClass();
}
