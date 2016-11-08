package org.almiso.giffy.network.core.task.imp;

import org.almiso.giffy.network.core.task.TaskProgressInterface;

/**
 * Default realisation of the {@link TaskProgressInterface TaskProgressInterface}.
 */
public class EmptyTaskProgressInterface implements TaskProgressInterface {

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }
}
