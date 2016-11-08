package org.almiso.giffy.network.core;


public class DefaultRequestParser implements RequestParser {

    @Override
    public RequestResponse parse(ServerResponse serverResponse, Class<? extends RequestResponse> responseClass) throws ParseException {
        try {
            RequestResponse response = responseClass.newInstance();
            return response.parse(serverResponse);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new ParseException();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new ParseException();
        }
    }
}
