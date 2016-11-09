package org.almiso.giffy.network.implementation.util;


import android.net.Uri;
import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestParamsEntry;
import org.almiso.giffy.network.core.request.NetworkRequestPath;
import org.almiso.giffy.network.core.util.UrlBuilder;

import java.net.MalformedURLException;
import java.net.URL;


public class GiffyUrlBuilder implements UrlBuilder {

    /* Data */

    private NetworkRequest networkRequest;

    /* Constructor */

    public GiffyUrlBuilder(@NonNull NetworkRequest networkRequest) {
        this.networkRequest = networkRequest;
    }

    /* Override methods */

    @Override
    public URL createUrl() throws MalformedURLException {
        switch (networkRequest.getRequestType()) {

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
        NetworkRequestPath path = networkRequest.getRequestPath();
        Uri uri = new Uri.Builder()
                .scheme(path.getScheme())
                .authority(path.getAuthority())
                .path(path.getPath())
                .build();

        return new URL(uri.toString());
    }

    private URL createGetUrl() throws MalformedURLException {
        NetworkRequestPath path = networkRequest.getRequestPath();
        NetworkRequestParams params = networkRequest.getParams();

        Uri.Builder builder = new Uri.Builder()
                .scheme(path.getScheme())
                .authority(path.getAuthority())
                .path(path.getPath());

        for (NetworkRequestParamsEntry entry : params.getParams()) {
            builder.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
        }

        return new URL(builder.build().toString());
    }
}
