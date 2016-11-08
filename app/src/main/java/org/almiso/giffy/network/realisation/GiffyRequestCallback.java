package org.almiso.giffy.network.realisation;

import org.almiso.giffy.network.core.RequestCallback;
import org.almiso.giffy.network.core.RequestResponse;

public abstract class GiffyRequestCallback<T extends RequestResponse> implements RequestCallback<T, GiffyError> {
}
