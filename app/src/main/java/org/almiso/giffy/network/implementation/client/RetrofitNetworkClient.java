package org.almiso.giffy.network.implementation.client;


import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.client.ServerCallback;
import org.almiso.giffy.network.core.exceprion.CustomException;
import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.implementation.api.RetrofitApi;
import org.almiso.giffy.network.implementation.model.Joke;
import org.almiso.giffy.network.implementation.util.RetrofitUrlBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNetworkClient implements NetworkClient {

    @Override
    public void execute(@NonNull NetworkRequest networkRequest, @NonNull ServerCallback callback) {

        URL url;
        try {
            url = new RetrofitUrlBuilder(networkRequest).createUrl();
        } catch (MalformedURLException e) {
            callback.onServerError(e);
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url.getAuthority())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<Joke> call = retrofitApi.getRandomJoke();

        Response<Joke> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            callback.onServerError(e);
        }

        // TODO: 10.11.16
        if (response.isSuccessful()) {
            //callback.onServerSuccess();
        } else {
            //callback.onServerError(new CustomException());
        }

        callback.onServerError(new CustomException());
    }
}