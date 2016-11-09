package org.almiso.giffy.network.implementation.request;


import org.almiso.giffy.network.core.request.NetworkRequestPath;

public class GiffyNetworkRequestPath implements NetworkRequestPath {

    private String scheme;
    private String authority;
    private String path;

    public GiffyNetworkRequestPath(String authority, String path) {
        this("http", authority, path);
    }

    public GiffyNetworkRequestPath(String scheme, String authority, String path) {
        this.scheme = scheme;
        this.authority = authority;
        this.path = path;
    }

    @Override
    public String getScheme() {
        return scheme;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public String getPath() {
        return path;
    }
}
