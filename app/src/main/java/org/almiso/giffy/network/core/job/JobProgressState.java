package org.almiso.giffy.network.core.job;

/**
 * Tasks progress interface.
 */
public interface JobProgressState {

    /**
     * Shows the progress in the UI.
     */
    void onStart();

    /**
     * Hide the progress in the UI.
     */
    void onFinish();
}
