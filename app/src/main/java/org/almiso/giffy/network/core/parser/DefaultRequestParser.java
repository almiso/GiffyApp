package org.almiso.giffy.network.core.parser;

import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.core.client.ServerResponse;

/**
 * Default realisation of the {@link RequestParser RequestParser}.
 */
public class DefaultRequestParser implements RequestParser {

    @Override
    public TaskResponse parse(ServerResponse serverResponse, Class<? extends TaskResponse> responseClass) throws ParseException {
        try {
            TaskResponse response = responseClass.newInstance();
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
