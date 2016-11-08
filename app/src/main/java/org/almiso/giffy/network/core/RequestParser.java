package org.almiso.giffy.network.core;


public interface RequestParser {

    RequestResponse parse(ServerResponse response, Class<? extends RequestResponse> responseClass) throws ParseException;
}
