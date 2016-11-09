package org.almiso.giffy.network.implementation.request;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.client.ServerCallback;
import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.parser.DefaultRequestParser;
import org.almiso.giffy.network.core.parser.ParseException;
import org.almiso.giffy.network.core.parser.RequestParser;
import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestPath;
import org.almiso.giffy.network.core.request.imp.EmptyNetworkRequestHeaders;
import org.almiso.giffy.network.core.request.imp.EmptyNetworkRequestParams;
import org.almiso.giffy.network.core.request.imp.EmptyNetworkRequestPath;
import org.almiso.giffy.network.core.job.imp.EmptyJobCallback;
import org.almiso.giffy.network.core.job.JobCallback;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.job.JobIdentifier;
import org.almiso.giffy.network.core.job.JobProgressState;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.job.JobType;
import org.almiso.giffy.network.core.job.imp.EmptyJobProgressState;
import org.almiso.giffy.network.implementation.client.GiffyNetworkClient;
import org.almiso.giffy.network.implementation.job.GiffyError;
import org.almiso.giffy.network.implementation.job.GiffyJobIdentifier;

public abstract class GiffyNetworkRequest implements NetworkRequest {

    /* Constants */

    private static final int DEFAULT_ATTEMPTS_COUNT = 1;
    private static final int DEFAULT_USED_ATTEMPTS_COUNT = 0;

    /* Data */

    /**
     * Looper which starts request
     */
    private Looper looper;

    /**
     * UI progress interface.
     */
    private JobProgressState jobProgressState;

    /**
     * NetworkRequest callback.
     */
    private JobCallback jobCallback;

    /**
     * NetworkRequest parser.
     */
    private RequestParser requestParser;

    /**
     * Specify attempts for request loading if caused HTTP-error. 0 for infinite
     */
    private int attempts;

    /**
     * How much times request was loaded
     */
    private int attemptsUsed;

    /* Abstract methods */

    protected abstract void prepareInjection(RequestComponent requestComponent);

    /* Constructor */

    protected GiffyNetworkRequest() {
        this.jobProgressState = new EmptyJobProgressState();
        this.jobCallback = new EmptyJobCallback();
        this.requestParser = new DefaultRequestParser();
        this.attempts = DEFAULT_ATTEMPTS_COUNT;
        this.attempts = DEFAULT_USED_ATTEMPTS_COUNT;
        this.looper = Looper.getMainLooper();

        prepareInjection(GiffyApplication.getRequestComponent());
    }

    /* Override methods */

    @Override
    final public void setCallback(@NonNull JobCallback jobCallback) {
        this.jobCallback = jobCallback;
    }

    @Override
    final public void setJobProgressState(@NonNull JobProgressState jobProgressState) {
        this.jobProgressState = jobProgressState;
    }

    @Override
    public void setAttemptsCount(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public JobType getJobType() {
        return JobType.ASYNCHRONOUS;
    }

    @Override
    public NetworkRequestParams getParams() {
        return new EmptyNetworkRequestParams();
    }

    @Override
    public NetworkRequestHeaders getHeaders() {
        return new EmptyNetworkRequestHeaders();
    }

    @Override
    public NetworkRequestPath getRequestPath() {
        return new EmptyNetworkRequestPath();
    }

    @Override
    public NetworkClient getClient() {
        return new GiffyNetworkClient();
    }

    @Override
    public JobIdentifier getIdentifier() {
        return new GiffyJobIdentifier("Some request");
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
            JobResponse response = requestParser.parse(serverResponse, getResponseClass());
            onSuccess(response);
        } catch (ParseException e) {
            e.printStackTrace();
            // TODO: 08.11.16 create parse error.
            onError(new GiffyError());
        }

        hideProgress();
    }

    private void processError(Throwable throwable) {
        JobError error = new GiffyError();

        hideProgress();
        onError(error);
    }

    private void showProgress() {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                jobProgressState.onStart();
            }
        });
    }

    private void hideProgress() {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                jobProgressState.onFinish();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void onSuccess(final JobResponse response) {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                jobCallback.onSuccess(response);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void onError(final JobError error) {
        runOnMainThread(new Runnable() {
            @Override
            public void run() {
                jobCallback.onError(error);
            }
        });
    }

    private void runOnMainThread(Runnable runnable) {
        new Handler(looper).post(runnable);
    }
}
