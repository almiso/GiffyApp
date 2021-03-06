package org.almiso.giffy.network.implementation.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Joke {

    @SerializedName("id")
    private int id;
    @SerializedName("joke")
    private String value;
    @SerializedName("categories")
    private List<String> categories;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", categories=" + categories +
                '}';
    }
}
