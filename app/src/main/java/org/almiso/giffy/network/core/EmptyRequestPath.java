package org.almiso.giffy.network.core;


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
