package src.utils;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtil {
    @SafeVarargs
    public static <T> List<T> buildList(T... elements) {
        ArrayList<T> ts = new ArrayList<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }

    public static int[] buildIntArray(int... elements) {
        return elements;
    }

    public static <T> void assertArrayEquals(T[] input, T[] expected) {
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

    public static void assertIntArrayEquals(int[] input, int[] expected) {
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

    public static char[][] buildCharGrid(String... rows) {
        if (rows.length == 0) {
            return new char[0][0];
        }
        char[][] grid = new char[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                grid[i][j] = rows[i].charAt(j);
            }
        }
        return grid;
    }
}
