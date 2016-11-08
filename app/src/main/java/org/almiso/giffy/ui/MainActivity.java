package org.almiso.giffy.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import org.almiso.giffy.App;
import org.almiso.giffy.R;
import org.almiso.giffy.network.core.ProgressInterface;
import org.almiso.giffy.network.core.TaskManager;
import org.almiso.giffy.network.realisation.GiffyError;
import org.almiso.giffy.network.realisation.GiffyNetworkRequest;
import org.almiso.giffy.network.realisation.GiffyRequestCallback;
import org.almiso.giffy.network.sample.GetRandomJokeResponse;
import org.almiso.giffy.network.sample.GiffyApi;
import org.almiso.giffy.network.sample.Joke;
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
        App.getNetworkComponent().inject(this);
    }

    /* Private methods */

    private void loadNextJoke() {
        GiffyNetworkRequest request = GiffyApi.test().getJokeForName("Alexandr", "Sosorev");
        request.setProgressInterface(new ProgressInterface() {
            @Override
            public void showProgress() {
                needShowProgress();
            }

            @Override
            public void hideProgress() {
                needHideProgress();
            }
        });

        request.setCallback(new GiffyRequestCallback<GetRandomJokeResponse>() {
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
