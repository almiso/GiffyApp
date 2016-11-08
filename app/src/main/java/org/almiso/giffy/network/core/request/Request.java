package org.almiso.giffy.network.core.request;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.task.Task;
import org.almiso.giffy.network.core.task.TaskResponse;

/**
 * Base network request.
 */
public interface Request extends Task {

    /**
     * Returns the {@link RequestPath path}.
     */
    RequestPath getRequestPath();

    /**
     * Returns the {@link RequestParams params}.
     */
    RequestParams getParams();

    /**
     * Returns the {@link RequestHeaders headers}.
     */
    RequestHeaders getHeaders();

    /**
     * Returns the {@link NetworkClient client}.
     */
    NetworkClient getClient();

    /**
     * Returns the {@link RequestType type}.
     */
    RequestType getRequestType();

    /**
     * Returns the {@link RequestPath path}.
     */
    Class<? extends TaskResponse> getResponseClass();

    /**
     * Specify attempts for request loading if caused HTTP-error. 0 for infinite.
     */
    void setAttemptsCount(int attemps);
}
