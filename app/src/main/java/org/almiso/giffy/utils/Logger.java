package org.almiso.giffy.utils;


import android.util.Log;

public class Logger {

    public static void d(String TAG, String message) {
        Log.d(TAG, message);
    }

    public static void e(String TAG, String message, Exception exception) {
        Log.e(TAG, message + exception);
    }
}
