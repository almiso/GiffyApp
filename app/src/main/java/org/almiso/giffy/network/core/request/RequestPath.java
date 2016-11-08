package org.almiso.giffy.network.core.request;

/**
 * Base network request path.
 * Contains scheme, authority and the path.
 */
public interface RequestPath {

    /**
     * Returns the scheme from the request.
     */
    String getScheme();

    /**
     * Returns the authority from the request.
     */
    String getAuthority();

    /**
     * Returns the path from the request.
     */
    String getPath();
}
