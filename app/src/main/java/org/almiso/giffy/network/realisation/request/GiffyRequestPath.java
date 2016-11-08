package org.almiso.giffy.network.realisation.request;


import org.almiso.giffy.network.core.request.RequestPath;

public class GiffyRequestPath implements RequestPath {

    private String scheme;
    private String authority;
    private String path;

    public GiffyRequestPath(String authority, String path) {
        this("http", authority, path);
    }

    public GiffyRequestPath(String scheme, String authority, String path) {
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

//    @Override
//    public URL getUrl(RequestParams params) throws MalformedURLException {
//
//        Uri.Builder builder = new Uri.Builder()
//                .scheme(getScheme())
//                .authority(getAuthority())
//                .path(getPath());
//
////        Iterator<RequestParamsEntry> iterator = params.getIterator();
////        while (iterator.hasNext()) {
////            RequestParamsEntry param = iterator.next();
////            builder.appendQueryParameter(param.getKey(), param.getValue());
////        }
//
//        Uri uri = builder.build();
//        return new URL(uri.toString());
//    }
}
