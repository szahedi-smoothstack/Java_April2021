package com.ss.jb.weekly;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FunctionalTests {

    @Test
    public void rightDigitTest() {
        Functional func = new Functional();

        List<Integer> listOne = Arrays.asList(1 , 22, 93);
        List<Integer> listTwo = Arrays.asList(16, 8, 886, 8, 1);
        List<Integer> listThree = Arrays.asList(10, 0);

        assertEquals(Arrays.asList(1, 2, 3), func.rightDigit(listOne));
        assertEquals(Arrays.asList(6, 8, 6, 8, 1), func.rightDigit(listTwo));
        assertEquals(Arrays.asList(0, 0), func.rightDigit(listThree));
    }

    @Test
    public void doubleTest() {
        Functional func = new Functional();

        List<Integer> listOne = Arrays.asList(1, 2, 3);
        List<Integer> listTwo = Arrays.asList(6, 8, 6, 8, -1);
        List<Integer> listThree = Arrays.asList();

        assertEquals(Arrays.asList(2, 4, 6), func.doubling(listOne));
        assertEquals(Arrays.asList(12, 16, 12, 16, -2), func.doubling(listTwo));
        assertEquals(Arrays.asList(), func.doubling(listThree));
    }

    @Test
    public void noXTest() {
        Functional func = new Functional();

        List<String> listOne = Arrays.asList("ax", "bb", "cx");
        List<String> listTwo = Arrays.asList("xxax", "xbxbx", "xxcx");
        List<String> listThree = Arrays.asList("x");

        assertEquals(Arrays.asList("a", "bb", "c"), func.noX(listOne));
        assertEquals(Arrays.asList("a", "bb", "c"), func.noX(listTwo));
        assertEquals(Arrays.asList(""), func.noX(listThree));
    }
}
