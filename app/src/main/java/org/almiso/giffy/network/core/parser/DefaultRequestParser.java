package org.almiso.giffy.network.core.parser;

import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.client.ServerResponse;

/**
 * Default realisation of the {@link RequestParser RequestParser}.
 */
public class DefaultRequestParser implements RequestParser {

    @Override
    public JobResponse parse(ServerResponse serverResponse, Class<? extends JobResponse> responseClass) throws ParseException {
        try {
            JobResponse response = responseClass.newInstance();
            return response.parse(serverResponse);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new ParseException();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new ParseException();
        }
    }
}
