package org.almiso.giffy.network.realisation.api.test;


import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.request.RequestParams;
import org.almiso.giffy.network.core.request.RequestPath;
import org.almiso.giffy.network.core.request.RequestType;
import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.realisation.model.GetRandomJokeResponse;
import org.almiso.giffy.network.realisation.request.GiffyRequest;
import org.almiso.giffy.network.realisation.request.GiffyRequestParams;
import org.almiso.giffy.network.realisation.request.GiffyRequestPath;

import javax.inject.Inject;

public class GetJokeForName extends GiffyRequest {

    /* Data */

    @Inject
    NetworkClient networkClient;

    private String firstName;
    private String lastName;

    /* Constructor */

    public GetJokeForName(String firstName, String lastName) {
        GiffyApplication.getClientComponent().inject(this);

        this.firstName = firstName;
        this.lastName = lastName;
    }

     /* Override methods */

    @Override
    public RequestPath getRequestPath() {
        return new GiffyRequestPath("api.icndb.com", "jokes/random");
    }

    @Override
    public RequestParams getParams() {
        GiffyRequestParams params = new GiffyRequestParams();
        params.putParam("firstName", firstName);
        params.putParam("lastName", lastName);
        return params;
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
