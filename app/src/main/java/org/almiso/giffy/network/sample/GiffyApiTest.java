package org.almiso.giffy.network.sample;


import org.almiso.giffy.network.realisation.GiffyNetworkRequest;

public class GiffyApiTest {

    public GiffyNetworkRequest getJokeForName(String firstName, String lastName) {
        return new GetJokeForName(firstName, lastName);
    }
}
