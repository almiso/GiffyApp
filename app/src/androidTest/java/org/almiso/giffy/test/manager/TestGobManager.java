package org.almiso.giffy.test.di.app;

import android.support.test.runner.AndroidJUnit4;

import org.almiso.giffy.network.core.job.JobType;
import org.almiso.giffy.network.core.request.NetworkRequest;
import org.almiso.giffy.network.implementation.manager.GiffyNetworkJobManager;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class TestGobManager {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    NetworkRequest request;

    @InjectMocks
    GiffyNetworkJobManager jobManager;

    @Test
    public void domeTest() {
        assertEquals(2, 2);
    }

    @Test
    public void testExecute() {
        when(request.getJobType()).thenReturn(JobType.SYNCHRONOUS);
        jobManager.addToQueue(request);
        verify(request).execute();
    }
}
