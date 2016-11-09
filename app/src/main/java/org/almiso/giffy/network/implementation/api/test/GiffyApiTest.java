package org.almiso.giffy.network.implementation.api.test;


import org.almiso.giffy.network.implementation.request.GiffyNetworkRequest;

public class GiffyApiTest {

    public GiffyNetworkRequest getRandomJoke() {
        return new GetRandomJoke();
    }

    public GiffyNetworkRequest getJokeForName(String firstName, String lastName) {
        return new GetJokeForName(firstName, lastName);
    }
}
