package org.almiso.giffy.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.almiso.giffy.R;
import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.network.core.job.JobError;
import org.almiso.giffy.network.core.manager.JobManager;
import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.implementation.api.GiffyApi;
import org.almiso.giffy.network.implementation.error.CustomError;
import org.almiso.giffy.network.implementation.job.GiffyJobCallback;
import org.almiso.giffy.network.implementation.model.GetRandomJokeResponse;
import org.almiso.giffy.network.implementation.model.Joke;
import org.almiso.giffy.utils.Logger;

import java.util.Random;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    /* Views */

    private TextView tvJokeText;

    /* Controls */

    @Inject
    JobManager manager;

    /* Common methods */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
    }

    /* Initialisation methods */

    private void initViews() {
        tvJokeText = (TextView) findViewById(R.id.tv_joke);
        findViewById(R.id.button_new_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNextJoke();
            }
        });
    }

    private void initData() {
        GiffyApplication.getNetworkComponent().inject(this);
    }

    /* Private methods */

    private void loadNextJoke() {
        NetworkRequest request = GiffyApi.test().getRandomJoke();
        request.setJobProgressState(getTaskProgressInterface());
        request.setAttemptsCount(10);
        request.setCallback(new GiffyJobCallback<GetRandomJokeResponse>() {
            @Override
            public void onSuccess(@NonNull GetRandomJokeResponse response) {
                Joke joke = response.getJoke();
                tvJokeText.setText(joke.getValue());
            }

            @Override
            public void onError(@NonNull JobError error) {
                if (error instanceof CustomError) {
                    CustomError customError = (CustomError) error;
                    customError.getResponse();
                }

                Logger.d(TAG, "error: " + error);
                showToast(error.getErrorMessage());
            }
        });
        manager.addToQueue(request);

        Random random = new Random();
        if (random.nextBoolean()) {
            manager.removeFromQueue(request.getIdentifier());
        }
    }

    /* Util methods */

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
