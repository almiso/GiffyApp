package org.almiso.giffy.network.realisation;


import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.DefaultRequestParser;
import org.almiso.giffy.network.core.EmptyProgressInterface;
import org.almiso.giffy.network.core.EmptyRequestCallback;
import org.almiso.giffy.network.core.EmptyRequestHeaders;
import org.almiso.giffy.network.core.EmptyRequestParams;
import org.almiso.giffy.network.core.EmptyRequestPath;
import org.almiso.giffy.network.core.NetworkClient;
import org.almiso.giffy.network.core.NetworkRequest;
import org.almiso.giffy.network.core.ParseException;
import org.almiso.giffy.network.core.ProgressInterface;
import org.almiso.giffy.network.core.RequestCallback;
import org.almiso.giffy.network.core.RequestError;
import org.almiso.giffy.network.core.RequestHeaders;
import org.almiso.giffy.network.core.RequestParams;
import org.almiso.giffy.network.core.RequestParser;
import org.almiso.giffy.network.core.RequestPath;
import org.almiso.giffy.network.core.RequestResponse;
import org.almiso.giffy.network.core.ServerCallback;
import org.almiso.giffy.network.core.ServerResponse;
import org.almiso.giffy.network.core.TaskIdentifier;
import org.almiso.giffy.network.core.TaskType;


public abstract class GiffyNetworkRequest implements NetworkRequest {

    /* Data */

    private Handler mainThreadHandler;

    private ProgressInterface progressInterface;
    private RequestCallback requestCallback;
    private RequestParser requestParser;

    /* Constructor */

    protected GiffyNetworkRequest() {
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.progressInterface = new EmptyProgressInterface();
        this.requestCallback = new EmptyRequestCallback();
        this.requestParser = new DefaultRequestParser();
    }

    /* Override methods */

    @Override
    final public void setCallback(@NonNull RequestCallback requestCallback) {
        this.requestCallback = requestCallback;
    }

    @Override
    final public void setProgressInterface(@NonNull ProgressInterface progressInterface) {
        this.progressInterface = progressInterface;
    }

    @Override
    public TaskType getTaskType() {
        return TaskType.ASYNCHRONOUS;
    }

    @Override
    public RequestParams getParams() {
        return new EmptyRequestParams();
    }

    @Override
    public RequestHeaders getHeaders() {
        return new EmptyRequestHeaders();
    }

    @Override
    public RequestPath getRequestPath() {
        return new EmptyRequestPath();
    }

    @Override
    public NetworkClient getClient() {
        return new GiffyNetworkClient();
    }

    @Override
    final public TaskIdentifier getIdentifier() {
        return new GiffyTaskIdentifier();
    }

    @Override
    final public void execute() {
        showProgress();

        executeRequest();
    }

    @Override
    final public void cancel() {

    }

    /* Private methods */

    private void executeRequest() {
        NetworkClient client = getClient();
        client.execute(this, new ServerCallback() {
            @Override
            public void onServerSuccess(ServerResponse response) {
                processResponse(response);
            }

            @Override
            public void onServerError(Throwable throwable) {
                processError(throwable);
            }
        });
    }

    private void processResponse(ServerResponse serverResponse) {
        try {
            RequestResponse response = requestParser.parse(serverResponse, getResponseClass());
            onSuccess(response);
        } catch (ParseException e) {
            e.printStackTrace();
            // TODO: 08.11.16 create parse error.
            onError(new GiffyError());
        }

        hideProgress();
    }

    private void processError(Throwable throwable) {
        RequestError error = new GiffyError();

        hideProgress();
        onError(error);
    }

    private void showProgress() {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                progressInterface.showProgress();
            }
        });
    }

    private void hideProgress() {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                progressInterface.hideProgress();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void onSuccess(final RequestResponse response) {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                requestCallback.onSuccess(response);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void onError(final RequestError error) {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                requestCallback.onError(error);
            }
        });
    }

    private void runOnMainThread(Runnable runnable) {
        mainThreadHandler.post(runnable);
    }
}
