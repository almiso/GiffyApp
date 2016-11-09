package org.almiso.giffy.core;


import android.app.Application;

public class GiffyApplication extends Application {

    private static ComponentController componentController;

    @Override
    public void onCreate() {
        super.onCreate();

        componentController = new ComponentController(this);
        componentController.init();
    }

    public static ComponentController getComponentController() {
        return componentController;
    }
}
