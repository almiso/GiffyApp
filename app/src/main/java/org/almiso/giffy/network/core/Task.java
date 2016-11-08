package org.almiso.giffy.network.core;


import android.support.annotation.NonNull;

public interface Task {

    TaskIdentifier getIdentifier();

    void execute();

    void cancel();

    void setCallback(@NonNull RequestCallback requestCallback);

    void setProgressInterface(@NonNull ProgressInterface progressInterface);

    TaskType getTaskType();
}
