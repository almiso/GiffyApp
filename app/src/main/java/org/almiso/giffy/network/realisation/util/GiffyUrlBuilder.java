package org.almiso.giffy.network.realisation.util;


import android.net.Uri;
import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.request.Request;
import org.almiso.giffy.network.core.request.RequestParams;
import org.almiso.giffy.network.core.request.RequestParamsEntry;
import org.almiso.giffy.network.core.request.RequestPath;
import org.almiso.giffy.network.core.util.UrlBuilder;

import java.net.MalformedURLException;
import java.net.URL;


public class GiffyUrlBuilder implements UrlBuilder {

    /* Data */

    private Request request;

    /* Constructor */

    public GiffyUrlBuilder(@NonNull Request request) {
        this.request = request;
    }

    /* Override methods */

    @Override
    public URL createUrl() throws MalformedURLException {
        switch (request.getRequestType()) {

            case POST:
            case PUT:
                return createPostUrl();

            case GET:
            case DELETE:
                return createGetUrl();

            default:
                throw new MalformedURLException("Unable to create URL.");
        }
    }

    /* Private methods */

    private URL createPostUrl() throws MalformedURLException {
        RequestPath path = request.getRequestPath();
        Uri uri = new Uri.Builder()
                .scheme(path.getScheme())
                .authority(path.getAuthority())
                .path(path.getPath())
                .build();

        return new URL(uri.toString());
    }

    private URL createGetUrl() throws MalformedURLException {
        RequestPath path = request.getRequestPath();
        RequestParams params = request.getParams();

        Uri.Builder builder = new Uri.Builder()
                .scheme(path.getScheme())
                .authority(path.getAuthority())
                .path(path.getPath());

        for (RequestParamsEntry entry : params.getParams()) {
            builder.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
        }

        return new URL(builder.build().toString());
    }
}
