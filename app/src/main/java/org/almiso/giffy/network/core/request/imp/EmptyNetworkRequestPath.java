package org.almiso.giffy.network.core.request.imp;

import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestPath;

/**
 * Default realisation of the {@link NetworkRequestParams NetworkRequestParams}.
 */
public class EmptyNetworkRequestPath implements NetworkRequestPath {

    @Override
    public String getScheme() {
        return "";
    }

    @Override
    public String getAuthority() {
        return "";
    }

    @Override
    public String getPath() {
        return "";
    }

}
