package org.almiso.giffy.network.implementation.api.test;


import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestPath;
import org.almiso.giffy.network.core.request.NetworkRequestType;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.implementation.model.GetRandomJokeResponse;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequest;
import org.almiso.giffy.network.implementation.request.GiffyNetworkRequestPath;

import javax.inject.Inject;

public class GetJokeForName extends GiffyNetworkRequest {

    /* Data */

    @Inject
    NetworkClient networkClient;

    @Inject
    NetworkRequestParams networkRequestParams;

    @Inject
    NetworkRequestHeaders networkRequestHeaders;

    private String firstName;
    private String lastName;

    /* Constructor */

    public GetJokeForName(String firstName, String lastName) {
        super();

        this.firstName = firstName;
        this.lastName = lastName;
    }

     /* Override methods */

    @Override
    protected void prepareInjection(RequestComponent requestComponent) {
        requestComponent.inject(this);
    }

    @Override
    public NetworkRequestPath getRequestPath() {
        return new GiffyNetworkRequestPath("api.icndb.com", "jokes/random");
    }

    @Override
    public NetworkRequestParams getParams() {
        networkRequestParams.putParam("firstName", firstName);
        networkRequestParams.putParam("lastName", lastName);
        return networkRequestParams;
    }

    @Override
    public NetworkRequestHeaders getHeaders() {
        return networkRequestHeaders;
    }

    @Override
    public NetworkRequestType getRequestType() {
        return NetworkRequestType.GET;
    }

    @Override
    public Class<? extends JobResponse> getResponseClass() {
        return GetRandomJokeResponse.class;
    }

    @Override
    public NetworkClient getClient() {
        return networkClient;
    }
}
