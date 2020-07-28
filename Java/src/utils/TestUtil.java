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

    public static int[][] buildIntXDArray(int x, int... elements) {
        int n = elements.length / x;
        int[][] ret = new int[n][x];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < x; j++) {
                ret[i][j] = elements[i * x + j];
            }
        }
        return ret;
    }

    public static <T> void assertArrayEquals(T[] expected, T[] input) throws Exception {
        if(expected.length != input.length) throw new Exception("input length error");
        for (int i = 0; i < expected.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

    public static void assertIntArrayEquals(int[] expected, int[] input) {
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

    public static <T> void assertListEquals(List<T> expected, List<T> input) throws Exception {
        TestUtil.assertArrayEquals(expected.toArray(), input.toArray());
    }

    public static void assertBlurEquals(double threshold, double expected, double actual){
        TestCase.assertTrue(Math.abs(expected-actual) <= threshold);
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
