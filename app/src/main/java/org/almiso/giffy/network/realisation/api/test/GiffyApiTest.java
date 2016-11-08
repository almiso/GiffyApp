package org.almiso.giffy.network.realisation.api.test;


import org.almiso.giffy.network.realisation.request.GiffyRequest;

public class GiffyApiTest {

    public GiffyRequest getRandomJoke() {
        return new GetRandomJoke();
    }

    public GiffyRequest getJokeForName(String firstName, String lastName) {
        return new GetJokeForName(firstName, lastName);
    }
}
