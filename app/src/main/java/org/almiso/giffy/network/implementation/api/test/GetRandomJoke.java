package org.almiso.giffy.network.implementation.api.test;


import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.job.JobIdentifier;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestPath;
import org.almiso.giffy.network.core.request.NetworkRequestType;
import org.almiso.giffy.network.implementation.job.GiffyJobIdentifier;
import org.almiso.giffy.network.implementation.model.GetRandomJokeResponse;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequest;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequestPath;

import javax.inject.Inject;

public class GetRandomJoke extends GiffyNetworkRequest {

    /* Data */

    @Inject
    NetworkClient networkClient;

    @Inject
    NetworkRequestParams networkRequestParams;

    @Inject
    NetworkRequestHeaders networkRequestHeaders;



    /* Override methods */

    @Override
    protected void prepareInjection(RequestComponent requestComponent) {
        requestComponent.inject(this);
    }

    @Override
    public NetworkRequestPath getRequestPath() {
//        return new GiffyNetworkRequestPath("api.icndb.com", "jokes/random");
        return new GiffyNetworkRequestPath("api.icndb.co", "jokes/random");
    }

    @Override
    public JobIdentifier getIdentifier() {
        return new GiffyJobIdentifier("GetRandomJoke");
    }

    @Override
    public NetworkRequestType getRequestType() {
        return NetworkRequestType.GET;
    }

    @Override
    public Class<? extends JobResponse> getResponseClass() {
        return GetRandomJokeResponse.class;
    }

    /* Getters */

    @Override
    public NetworkRequestParams getParams() {
        return networkRequestParams;
    }

    @Override
    public NetworkRequestHeaders getHeaders() {
        return networkRequestHeaders;
    }

    @Override
    public NetworkClient getClient() {
        return networkClient;
    }
}
