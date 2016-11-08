package org.almiso.giffy.network.realisation.api.test;


import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.request.RequestPath;
import org.almiso.giffy.network.core.request.RequestType;
import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.realisation.model.GetRandomJokeResponse;
import org.almiso.giffy.network.realisation.request.GiffyRequest;
import org.almiso.giffy.network.realisation.request.GiffyRequestPath;

import javax.inject.Inject;

public class GetRandomJoke extends GiffyRequest {

    /* Data */

    @Inject
    NetworkClient networkClient;

    /* Constructor */

    public GetRandomJoke() {
        GiffyApplication.getClientComponent().inject(this);
    }

     /* Override methods */

    @Override
    public RequestPath getRequestPath() {
        return new GiffyRequestPath("api.icndb.com", "jokes/random");
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.GET;
    }

    @Override
    public Class<? extends TaskResponse> getResponseClass() {
        return GetRandomJokeResponse.class;
    }

    @Override
    public NetworkClient getClient() {
        return networkClient;
    }
}
