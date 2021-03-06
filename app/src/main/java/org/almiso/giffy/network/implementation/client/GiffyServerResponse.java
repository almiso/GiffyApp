package org.almiso.giffy.network.implementation.client;


import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.client.ServerResponse;

import java.io.IOException;

import okhttp3.Response;

public class GiffyServerResponse implements ServerResponse<Response> {

    private Response response;

    public GiffyServerResponse(Response response) {
        this.response = response;
    }

    @Override
    public String getResponseString() throws ParseException {
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ParseException(e);
        }
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
