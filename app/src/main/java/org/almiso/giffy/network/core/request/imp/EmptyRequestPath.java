package org.almiso.giffy.network.core.request.imp;

import org.almiso.giffy.network.core.request.RequestParams;
import org.almiso.giffy.network.core.request.RequestPath;

/**
 * Default realisation of the {@link RequestParams RequestParams}.
 */
public class EmptyRequestPath implements RequestPath {

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
