package org.almiso.giffy.network.realisation;


import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.NetworkClient;
import org.almiso.giffy.network.core.NetworkRequest;
import org.almiso.giffy.network.core.RequestHeadersEntry;
import org.almiso.giffy.network.core.RequestParamsEntry;
import org.almiso.giffy.network.core.ServerCallback;
import org.almiso.giffy.network.core.UrlBuilder;
import org.almiso.giffy.utils.Constants;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class GiffyNetworkClient implements NetworkClient {

    // TODO: 08.11.16 decide how to remove this constants.
    private static final MediaType URLENCODED = MediaType.parse("application/x-www-form-urlencoded");
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    /* Constructor */

    public GiffyNetworkClient() {
    }

    /* Override methods */

    @Override
    public void execute(@NonNull NetworkRequest networkRequest, @NonNull ServerCallback callback) {

        URL url;

        try {
            UrlBuilder urlBuilder = new GiffyUrlBuilder(networkRequest);
            url = urlBuilder.createUrl();
        } catch (MalformedURLException | IllegalArgumentException e) {
            e.printStackTrace();
            callback.onServerError(e);
            return;
        }

        try {
            Request.Builder builder = new Request.Builder().url(url);
            for (RequestHeadersEntry entry : networkRequest.getHeaders().getHeaders()) {
                builder.header(entry.getKey(), entry.getValue());
            }

            prepareRequest(networkRequest, builder);

            Response response = getClient().newCall(builder.build()).execute();
            callback.onServerSuccess(new GiffyServerResponse(response));
        } catch (IOException e) {
            e.printStackTrace();
            callback.onServerError(e);
        }
    }

    /* Private methods */

    private void prepareRequest(@NonNull NetworkRequest networkRequest, @NonNull Request.Builder builder) throws IOException {
        switch (networkRequest.getRequestType()) {

            case POST:
                RequestBody postBody = createRequestBody(networkRequest);
                builder.post(postBody);
                break;

            case GET:
                builder.get();
                break;

            case PUT:
                RequestBody deleteBody = createRequestBody(networkRequest);
                builder.put(deleteBody);
                break;

            case DELETE:
                builder.delete();
                break;
        }
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    // TODO: 08.11.16 fix creating request body
    private RequestBody createRequestBody(@NonNull NetworkRequest networkRequest) throws UnsupportedEncodingException {
//        MediaType mediaType = getMediaType();
//        MediaType mediaType = getMediaType();
//        if (mediaType == JSON) {
//            return RequestBody.create(JSON, new JSONObject(networkRequest.getParams().getParams()).toString());
//        }
        return RequestBody.create(URLENCODED, getParamsString(networkRequest.getParams().getParams()));
    }


    private String getParamsString(List<RequestParamsEntry> params) throws UnsupportedEncodingException {
        return getParamsString(params, "&", true);
    }

    private String getParamsString(List<RequestParamsEntry> params, String separator, boolean isNeedEncode)
            throws UnsupportedEncodingException {

        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (RequestParamsEntry entry : params) {
            if (first) {
                first = false;
            } else {
                result.append(separator);
            }

            result.append(isNeedEncode ? URLEncoder.encode(entry.getKey(), "UTF-8") : entry.getKey());
            result.append("=");
            result.append(isNeedEncode ? URLEncoder.encode(entry.getValue().toString(), "UTF-8") : entry.getValue());
        }
        return result.toString();
    }

}
