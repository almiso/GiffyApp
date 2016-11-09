package org.almiso.giffy.network.core.request;

import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.job.Job;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.parser.Parser;

/**
 * Base network request.
 */
public interface NetworkRequest extends Job {

    /**
     * Returns the {@link NetworkRequestPath path}.
     */
    NetworkRequestPath getRequestPath();

    /**
     * Returns the {@link NetworkRequestParams params}.
     */
    NetworkRequestParams getParams();

    /**
     * Returns the {@link NetworkRequestHeaders headers}.
     */
    NetworkRequestHeaders getHeaders();

    /**
     * Returns the {@link NetworkClient client}.
     */
    NetworkClient getClient();

    /**
     * Returns the {@link NetworkRequestType type}.
     */
    NetworkRequestType getRequestType();

    /**
     * Returns the parser with will parse success response.
     */
    Parser getResponseParser();

    /**
     * Returns the success response model class.
     */
    Class<? extends JobResponse> getResponseClass();

    /**
     * Returns the parser with will parse error response.
     */
    Parser getErrorParser();

    /**
     * Returns the error response model class.
     */
    Class<? extends JobResponse> getErrorClass();

    /**
     * Specify attempts for request loading if caused HTTP-error. 0 for infinite.
     */
    void setAttemptsCount(int attempts);
}
