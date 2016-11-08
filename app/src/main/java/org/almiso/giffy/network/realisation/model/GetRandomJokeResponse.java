package org.almiso.giffy.network.realisation.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.almiso.giffy.network.core.parser.ParseException;
import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.core.client.ServerResponse;

public class GetRandomJokeResponse implements TaskResponse {

    @SerializedName("value")
    private Joke joke;

    public Joke getJoke() {
        return joke;
    }

    @Override
    public TaskResponse parse(ServerResponse serverResponse) throws ParseException {
        return new GsonBuilder().create().fromJson(serverResponse.getResponseString(), GetRandomJokeResponse.class);
    }
}
