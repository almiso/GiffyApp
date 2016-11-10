package org.almiso.giffy.test.core;


import org.almiso.giffy.core.ComponentController;
import org.almiso.giffy.core.GiffyApplication;

public class TestGiffyApplication extends GiffyApplication {

    private static TestComponentController componentController;

    @Override
    public void onCreate() {
        super.onCreate();

        componentController = new TestComponentController(this);
        componentController.init();
    }

    public static ComponentController getComponentController() {
        return componentController;
    }
}
