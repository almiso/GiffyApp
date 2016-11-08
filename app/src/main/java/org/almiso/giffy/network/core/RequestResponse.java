package org.almiso.giffy.network.core;


public interface RequestResponse {

    RequestResponse parse(ServerResponse serverResponse) throws ParseException;
}
