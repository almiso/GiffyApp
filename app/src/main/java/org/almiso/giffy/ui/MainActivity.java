package org.almiso.giffy.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import org.almiso.giffy.core.GiffyApplication;
import org.almiso.giffy.R;
import org.almiso.giffy.network.core.manager.TaskManager;
import org.almiso.giffy.network.realisation.api.GiffyApi;
import org.almiso.giffy.network.realisation.model.GetRandomJokeResponse;
import org.almiso.giffy.network.realisation.model.Joke;
import org.almiso.giffy.network.realisation.request.GiffyRequest;
import org.almiso.giffy.network.realisation.task.GiffyError;
import org.almiso.giffy.network.realisation.task.GiffyTaskCallback;
import org.almiso.giffy.utils.Logger;

import java.util.Random;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    /* Views */

    private TextView tvJokeText;

    /* Controls */

    @Inject
    TaskManager manager;

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
        GiffyRequest request = GiffyApi.test().getRandomJoke();
        request.setProgressInterface(getTaskProgressInterface());
        request.setCallback(new GiffyTaskCallback<GetRandomJokeResponse>() {
            @Override
            public void onSuccess(@NonNull GetRandomJokeResponse response) {
                Joke joke = response.getJoke();
                tvJokeText.setText(joke.getValue());
            }

            @Override
            public void onError(@NonNull GiffyError error) {
                Logger.d(TAG, "error: " + error);
            }
        });
        manager.executeTask(request);

        Random random = new Random();
        if (random.nextBoolean()) {
            manager.cancelTask(request.getIdentifier());
        }
    }
}
