package org.almiso.giffy.network.implementation.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.job.JobResponse;

public class GetRandomJokeResponse implements JobResponse {

    @SerializedName("value")
    private Joke joke;

    public Joke getJoke() {
        return joke;
    }

    @Override
    public JobResponse parse(ServerResponse serverResponse) throws Exception {
        return new GsonBuilder().create().fromJson(serverResponse.getResponseString(), GetRandomJokeResponse.class);
    }
}
