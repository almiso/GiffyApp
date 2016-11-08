package org.almiso.giffy.network.realisation.task;

import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.task.TaskIdentifier;

public class GiffyTaskIdentifier implements TaskIdentifier<String> {

    private String identifier;

    public GiffyTaskIdentifier(@NonNull String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }
}
