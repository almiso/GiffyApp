package org.almiso.giffy.network.core.parser;

import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.client.ServerResponse;

/**
 * Base parser class.
 */
public interface Parser {

    /**
     * Parse server response to the model class.
     */
    JobResponse parse(ServerResponse response, Class<? extends JobResponse> responseClass) throws ParseException;
}
