package com.ss.jb.weekly;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecursionTest {

    @Test
    public void groupSumClumpTest() {
        Recursion rec = new Recursion();

        assertTrue(rec.groupSumClump(0, new int[] {2, 4, 8}, 10));
        assertTrue(rec.groupSumClump(0, new int[] {1, 2, 4, 8, 1}, 14));
        assertFalse(rec.groupSumClump(0, new int[] {2, 4, 4, 8}, 14));

    }
}
