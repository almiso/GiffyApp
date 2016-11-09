package org.almiso.giffy.network.core.parser;


import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.job.JobResponse;

public class ErrorParser implements Parser {

    @Override
    public JobResponse parse(ServerResponse serverResponse, Class<? extends JobResponse> responseClass) throws ParseException {
        throw new ParseException(new Exception());
    }
}
