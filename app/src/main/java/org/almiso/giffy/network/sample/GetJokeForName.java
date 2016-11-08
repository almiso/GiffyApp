package org.almiso.giffy.network.sample;


import org.almiso.giffy.network.core.NetworkClient;
import org.almiso.giffy.network.core.RequestParams;
import org.almiso.giffy.network.core.RequestPath;
import org.almiso.giffy.network.core.RequestResponse;
import org.almiso.giffy.network.core.RequestType;
import org.almiso.giffy.network.realisation.GiffyNetworkClient;
import org.almiso.giffy.network.realisation.GiffyNetworkRequest;
import org.almiso.giffy.network.realisation.GiffyRequestParams;
import org.almiso.giffy.network.realisation.GiffyRequestPath;

public class GetJokeForName extends GiffyNetworkRequest {

    /* Data */

    /**
     * Client will be injected.
     */
    private NetworkClient networkClient;

    private String firstName;
    private String lastName;

    /* Constructor */

    public GetJokeForName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.networkClient = new GiffyNetworkClient();
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
    public Class<? extends RequestResponse> getResponseClass() {
        return GetRandomJokeResponse.class;
    }

    @Override
    public NetworkClient getClient() {
        return networkClient;
    }
}
