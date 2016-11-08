package org.almiso.giffy.network.realisation.task;

import org.almiso.giffy.network.core.task.TaskCallback;
import org.almiso.giffy.network.core.task.TaskResponse;
import org.almiso.giffy.network.realisation.task.GiffyError;

public abstract class GiffyTaskCallback<T extends TaskResponse> implements TaskCallback<T, GiffyError> {
}
