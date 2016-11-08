package org.almiso.giffy.network.core.parser;

import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.core.client.ServerResponse;

/**
 * Base parser class.
 */
public interface RequestParser {

    /**
     * Parse server response to the model class.
     */
    TaskResponse parse(ServerResponse response, Class<? extends TaskResponse> responseClass) throws ParseException;
}
