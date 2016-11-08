package org.almiso.giffy.network.realisation;


import org.almiso.giffy.network.core.RequestError;

public class GiffyError implements RequestError {

    @Override
    public String getErrorMessage() {
        return "Error";
    }
}
