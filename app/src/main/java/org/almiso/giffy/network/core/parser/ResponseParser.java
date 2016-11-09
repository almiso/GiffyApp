package org.almiso.giffy.network.core.parser;

import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.client.ServerResponse;

/**
 * Default realisation of the {@link Parser Parser}.
 */
public class ResponseParser implements Parser {

    @Override
    public JobResponse parse(ServerResponse serverResponse, Class<? extends JobResponse> responseClass) throws ParseException {
        try {
            JobResponse response = responseClass.newInstance();
            return response.parse(serverResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParseException(e);
        }
    }
}
