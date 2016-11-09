package org.almiso.giffy.network.core.job;

/**
 * Base error class.
 */
public interface JobError<T extends Throwable> {

    String getErrorMessage();

    T getException();
}
