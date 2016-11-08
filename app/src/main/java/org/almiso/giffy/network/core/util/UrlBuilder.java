package org.almiso.giffy.network.core.util;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * base URL builder class.
 */
public interface UrlBuilder {

    /**
     * Creates url for the request.
     */
    URL createUrl() throws MalformedURLException;
}
