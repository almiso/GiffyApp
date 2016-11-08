package org.almiso.giffy.network.core;


import java.net.MalformedURLException;
import java.net.URL;

public interface UrlBuilder {

    URL createUrl() throws MalformedURLException;
}
