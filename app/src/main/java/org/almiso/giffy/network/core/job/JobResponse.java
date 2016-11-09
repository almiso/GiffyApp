package org.almiso.giffy.network.core.job;

import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.parser.ParseException;

/**
 * Base response class.
 * Contains the response and method for parsing.
 */
public interface JobResponse {

    /**
     * Parse the server response to the model.
     */
    JobResponse parse(ServerResponse serverResponse) throws ParseException;
}
