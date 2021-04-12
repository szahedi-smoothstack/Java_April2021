package com.ss.jb.four;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DoubleCheckedSingletonTests {

    @Test
    public void getInstanceTest() {
        DoubleCheckedSingleton dcs = DoubleCheckedSingleton.getInstance();
        assertNotNull(dcs);
    }
}
