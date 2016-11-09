package org.almiso.giffy.ui;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.almiso.giffy.R;
import org.almiso.giffy.network.core.job.JobProgressState;
import org.almiso.giffy.utils.Logger;

public class BaseActivity extends AppCompatActivity {

    /* Constants */

    protected String TAG;

    /* Views */

    private ProgressDialog progressDialog;

    /* Common methods */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = this.getClass().getSimpleName();
    }

    /* UI methods */

    protected void needShowProgress() {
        if (isFinishing() || progressDialog != null) {
            return;
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.st_app_name);
        progressDialog.setMessage(getString(R.string.st_loading));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    protected void needHideProgress() {
        if (progressDialog == null) {
            return;
        }

        try {
            progressDialog.dismiss();
        } catch (Exception e) {
            Logger.e(TAG, "needHideProgress", e);
        }
        progressDialog = null;
    }

    protected JobProgressState getTaskProgressInterface() {
        return new JobProgressState() {
            @Override
            public void onStart() {
                needShowProgress();
            }

            @Override
            public void onFinish() {
                needHideProgress();
            }
        };
    }
}
