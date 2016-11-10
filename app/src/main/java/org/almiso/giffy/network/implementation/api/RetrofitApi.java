package org.almiso.giffy.network.implementation.api;


import org.almiso.giffy.network.implementation.model.Joke;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("/jokes/random")
    Call<Joke> getRandomJoke();
}
