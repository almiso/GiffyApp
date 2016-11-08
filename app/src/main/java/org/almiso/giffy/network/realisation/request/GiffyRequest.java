package org.almiso.giffy.network.realisation.request;


import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import org.almiso.giffy.network.core.task.imp.EmptyTaskProgressInterface;
import org.almiso.giffy.network.core.task.TaskProgressInterface;
import org.almiso.giffy.network.core.parser.DefaultRequestParser;
import org.almiso.giffy.network.core.request.imp.EmptyTaskCallback;
import org.almiso.giffy.network.core.request.imp.EmptyRequestHeaders;
import org.almiso.giffy.network.core.request.imp.EmptyRequestParams;
import org.almiso.giffy.network.core.request.imp.EmptyRequestPath;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.request.Request;
import org.almiso.giffy.network.core.parser.ParseException;
import org.almiso.giffy.network.core.task.TaskCallback;
import org.almiso.giffy.network.core.task.TaskError;
import org.almiso.giffy.network.core.request.RequestHeaders;
import org.almiso.giffy.network.core.request.RequestParams;
import org.almiso.giffy.network.core.parser.RequestParser;
import org.almiso.giffy.network.core.request.RequestPath;
import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.core.client.ServerCallback;
import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.task.TaskIdentifier;
import org.almiso.giffy.network.core.task.TaskType;
import org.almiso.giffy.network.realisation.task.GiffyError;
import org.almiso.giffy.network.realisation.task.GiffyTaskIdentifier;
import org.almiso.giffy.network.realisation.client.GiffyNetworkClient;


public abstract class GiffyRequest implements Request {

    /* Data */

    private Handler mainThreadHandler;

    private TaskProgressInterface taskProgressInterface;
    private TaskCallback taskCallback;
    private RequestParser requestParser;

    /* Constructor */

    protected GiffyRequest() {
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.taskProgressInterface = new EmptyTaskProgressInterface();
        this.taskCallback = new EmptyTaskCallback();
        this.requestParser = new DefaultRequestParser();
    }

    /* Override methods */

    @Override
    final public void setCallback(@NonNull TaskCallback taskCallback) {
        this.taskCallback = taskCallback;
    }

    @Override
    final public void setProgressInterface(@NonNull TaskProgressInterface taskProgressInterface) {
        this.taskProgressInterface = taskProgressInterface;
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
        return new GiffyTaskIdentifier("Some request");
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
            TaskResponse response = requestParser.parse(serverResponse, getResponseClass());
            onSuccess(response);
        } catch (ParseException e) {
            e.printStackTrace();
            // TODO: 08.11.16 create parse error.
            onError(new GiffyError());
        }

        hideProgress();
    }

    private void processError(Throwable throwable) {
        TaskError error = new GiffyError();

        hideProgress();
        onError(error);
    }

    private void showProgress() {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                taskProgressInterface.showProgress();
            }
        });
    }

    private void hideProgress() {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                taskProgressInterface.hideProgress();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void onSuccess(final TaskResponse response) {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                taskCallback.onSuccess(response);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void onError(final TaskError error) {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                taskCallback.onError(error);
            }
        });
    }

    private void runOnMainThread(Runnable runnable) {
        mainThreadHandler.post(runnable);
    }
}