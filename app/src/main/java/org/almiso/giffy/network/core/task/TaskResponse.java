package org.almiso.giffy.network.core.task;

import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.parser.ParseException;

/**
 * Base response class.
 * Contains the response and method for parsing.
 */
public interface TaskResponse {

    /**
     * Parse the server response to the model.
     */
    TaskResponse parse(ServerResponse serverResponse) throws ParseException;
}
