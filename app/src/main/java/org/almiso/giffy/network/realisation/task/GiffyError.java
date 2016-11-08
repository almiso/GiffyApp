package org.almiso.giffy.network.realisation.task;


import org.almiso.giffy.network.core.task.TaskError;

public class GiffyError implements TaskError {

    @Override
    public String getErrorMessage() {
        return "Error";
    }
}
