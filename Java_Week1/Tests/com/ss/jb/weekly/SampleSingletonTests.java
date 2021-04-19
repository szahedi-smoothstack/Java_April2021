package com.ss.jb.weekly;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SampleSingletonTests {

    @Test
    public void getInstanceTest() {
        SampleSingleton ss = SampleSingleton.getInstance();

        assertNotNull(ss);
        assertTrue(ss instanceof SampleSingleton);
    }
}
