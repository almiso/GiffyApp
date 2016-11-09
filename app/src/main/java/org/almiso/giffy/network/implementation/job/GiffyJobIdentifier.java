package org.almiso.giffy.network.implementation.job;

import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.job.JobIdentifier;

public class GiffyJobIdentifier implements JobIdentifier<String> {

    private String identifier;

    public GiffyJobIdentifier(@NonNull String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
}
