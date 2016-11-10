package org.almiso.giffy.network.implementation.util;


import android.net.Uri;
import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.core.request.NetworkRequestPath;
import org.almiso.giffy.network.core.util.UrlBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class RetrofitUrlBuilder implements UrlBuilder {

    /* Data */

    private NetworkRequest networkRequest;

    /* Constructor */

    public RetrofitUrlBuilder(@NonNull NetworkRequest networkRequest) {
        this.networkRequest = networkRequest;
    }

    @Override
    public URL createUrl() throws MalformedURLException {
        return createPostUrl();
    }

    private URL createPostUrl() throws MalformedURLException {
        NetworkRequestPath path = networkRequest.getRequestPath();

        Uri uri = new Uri.Builder()
                .scheme(path.getScheme())
                .authority(path.getAuthority())
                .build();

        return new URL(uri.toString());
    }
}
