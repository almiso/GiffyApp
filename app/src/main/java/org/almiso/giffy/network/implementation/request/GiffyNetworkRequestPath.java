package org.almiso.giffy.network.implementation.request;


import org.almiso.giffy.network.core.request.NetworkRequestPath;

public class GiffyNetworkRequestPath implements NetworkRequestPath {

    private String scheme;
    private String authority;
    private String path;

    private GiffyNetworkRequestPath() {
        this.scheme = "http";
        this.authority = "";
        this.path = "";
    }

    public static Builder newBuilder() {
        return new GiffyNetworkRequestPath().new Builder();
    }

    public class Builder {

        public Builder setScheme(String scheme) {
            GiffyNetworkRequestPath.this.scheme = scheme;
            return this;
        }

        public Builder setAuthority(String authority) {
            GiffyNetworkRequestPath.this.authority = authority;
            return this;
        }

        public Builder setPath(String path) {
            GiffyNetworkRequestPath.this.path = path;
            return this;
        }

        public GiffyNetworkRequestPath build() {
            return GiffyNetworkRequestPath.this;
        }
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
