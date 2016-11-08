package org.almiso.giffy.network.sample;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.almiso.giffy.network.core.ParseException;
import org.almiso.giffy.network.core.RequestResponse;
import org.almiso.giffy.network.core.ServerResponse;

public class GetRandomJokeResponse implements RequestResponse {

    @SerializedName("value")
    private Joke joke;

    public Joke getJoke() {
        return joke;
    }

    @Override
    public RequestResponse parse(ServerResponse serverResponse) throws ParseException {
        return new GsonBuilder().create().fromJson(serverResponse.getResponseString(), GetRandomJokeResponse.class);
    }
}
