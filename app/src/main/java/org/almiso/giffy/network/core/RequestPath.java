package org.almiso.giffy.network.core;


public interface RequestPath {

    String getScheme();

    String getAuthority();

    String getPath();
}
