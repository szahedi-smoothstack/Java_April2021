package com.ss.jb.weekly;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LambdasTest {

    @Test
    public void testTypeTest() {
        Lambdas l = new Lambdas();

        assertTrue(l.testType(l.isOdd(), 3));
        assertFalse(l.testType(l.isOdd(), 4));

        assertTrue(l.testType(l.isPrime(), 3));
        assertFalse(l.testType(l.isPrime(), 16));

        assertTrue(l.testType(l.isPalindrome(), 898));
        assertFalse(l.testType(l.isPalindrome(), 25));
    }
}
