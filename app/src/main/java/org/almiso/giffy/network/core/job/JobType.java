package org.almiso.giffy.network.core.job;

/**
 * Job type.
 * Defines in which queue the task will be executed.
 */
public enum JobType {
    // TODO: 09.11.16 rename to sign and un sign
    SYNCHRONOUS, ASYNCHRONOUS, SIGN, UNSIGN
}
