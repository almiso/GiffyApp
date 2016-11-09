package org.almiso.giffy.network.implementation.request;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.di.client.RequestComponent;
import org.almiso.giffy.network.core.client.NetworkClient;
import org.almiso.giffy.network.core.client.ServerCallback;
import org.almiso.giffy.network.core.client.ServerResponse;
import org.almiso.giffy.network.core.exceprion.ParseException;
import org.almiso.giffy.network.core.job.JobCallback;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.job.JobIdentifier;
import org.almiso.giffy.network.core.job.JobProgressState;
import org.almiso.giffy.network.core.job.JobResponse;
import org.almiso.giffy.network.core.job.JobType;
import org.almiso.giffy.network.core.job.imp.EmptyJobCallback;
import org.almiso.giffy.network.core.job.imp.EmptyJobProgressState;
import org.almiso.giffy.network.core.parser.ErrorParser;
import org.almiso.giffy.network.core.parser.Parser;
import org.almiso.giffy.network.core.parser.ResponseParser;
import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.core.request.NetworkRequestHeaders;
import org.almiso.giffy.network.core.request.NetworkRequestParams;
import org.almiso.giffy.network.core.request.NetworkRequestPath;
import org.almiso.giffy.network.core.request.imp.EmptyNetworkRequestHeaders;
import org.almiso.giffy.network.core.request.imp.EmptyNetworkRequestParams;
import org.almiso.giffy.network.core.request.imp.EmptyNetworkRequestPath;
import org.almiso.giffy.network.implementation.client.GiffyNetworkClient;
import org.almiso.giffy.network.implementation.error.CustomError;
import org.almiso.giffy.network.implementation.job.GiffyJobIdentifier;
import org.almiso.giffy.network.implementation.util.GiffyErrorBuilder;

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
        this.attempts = DEFAULT_ATTEMPTS_COUNT;
        this.attempts = DEFAULT_USED_ATTEMPTS_COUNT;
        this.looper = Looper.getMainLooper();

        prepareInjection(GiffyApplication.getComponentController().getRequestComponent());
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
    public Parser getResponseParser() {
        return new ResponseParser();
    }

    @Override
    public Parser getErrorParser() {
        return new ErrorParser();
    }

    @Override
    public Class<? extends JobResponse> getErrorClass() {
        return null;
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

    /* Process success */

    private void processResponse(ServerResponse serverResponse) {
        try {
            JobResponse error = getErrorParser().parse(serverResponse, getErrorClass());
            provideError(new CustomError(error));
            return;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JobResponse response;
        try {
            response = getResponseParser().parse(serverResponse, getResponseClass());
        } catch (ParseException e) {
            e.printStackTrace();
            processError(e);
            return;
        }

        provideResponse(response);
    }

    private void provideResponse(JobResponse response) {
        hideProgress();
        onSuccess(response);
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

    /* Process error */

    private void processError(Throwable throwable) {
        GiffyErrorBuilder errorBuilder = new GiffyErrorBuilder(throwable);
        JobError error = errorBuilder.createError();

        provideError(error);
    }

    private void provideError(JobError error) {
        hideProgress();
        onError(error);
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

    /* Util methods */

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

    private void runOnMainThread(Runnable runnable) {
        new Handler(looper).post(runnable);
    }
}
