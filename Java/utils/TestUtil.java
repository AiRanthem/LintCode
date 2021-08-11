package utils;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import java.util.*;

/**
 * 测试中用到的各种工具方法。包括：
 * build开头的方法：数据结构的生成，比如生成数组、字符串转数组、生成List等
 * cast开头的方法：类型转换
 * assert开头的方法：通过封装一些Junit的assert方法实现了对原生的assert的增强
 * print开头的方法：打印一些必要数据
 */
public class TestUtil {
    @SafeVarargs
    public static <T> List<T> buildList(T... elements) {
        ArrayList<T> ts = new ArrayList<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }

    @SafeVarargs
    public static <T> Set<T> buildSet(T... elements){
        HashSet<T> ts = new HashSet<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }

    @SafeVarargs
    public static <T> T[] buildArray(T... elements){
        return elements;
    }

    public static int[] buildIntArray(int... elements) {
        return elements;
    }

    public static Integer[] buildIntegerArray(Integer... elements) {
        return buildArray(elements);
    }

    /**
     * 生成一个size为[,x]的二维数组
     * @param x 每一个一维数组元素多大
     * @param elements 所有元素
     * @return 二维数组
     */
    public static int[][] buildInt2DArray(int x, int... elements) {
        int n = elements.length / x;
        int[][] ret = new int[n][x];
        for (int i = 0; i < n; i++) {
            System.arraycopy(elements, i * x, ret[i], 0, x);
        }
        return ret;
    }

    /**
     * 老版本命名失误，弃用，请使用buildInt2DArray.
     */
    @Deprecated
    public static int[][] buildIntXDArray(int x, int... elements){
        return buildInt2DArray(x, elements);
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

    public static Integer[] castInt2IntegerArray(int[] array) {
        Integer[] res = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        return res;
    }

    public static <T> void assertArrayEquals(T[] expected, T[] actual) {
        if (expected.length != actual.length) throw new AssertionFailedError("actual length error");
        for (int i = 0; i < expected.length; i++) {
            if(!expected[i].equals(actual[i])){
                System.out.printf("arrays first differed at element [%d]\n", i);
                System.out.print("Expected :");
                for (T t : expected) {
                    System.out.printf(" %s", t);
                }
                System.out.println();

                System.out.print("Actual   :");
                for (T t : actual) {
                    System.out.printf(" %s", t);
                }
                System.out.println();
                throw new AssertionFailedError();
            }
        }
    }

    public static void assertIntArrayEquals(int[] expected, int[] input) {
        TestUtil.assertArrayEquals(
                TestUtil.castInt2IntegerArray(expected),
                TestUtil.castInt2IntegerArray(input)
        );
    }

    public static <T> void assertListEquals(List<T> expected, List<T> input) {
        TestUtil.assertArrayEquals(expected.toArray(), input.toArray());
    }

    public static void assertBlurEquals(double threshold, double expected, double actual) {
        TestCase.assertTrue(Math.abs(expected - actual) <= threshold);
    }

    public static void printStrings(List<String> strings){
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
    }

    public static List<String> parsePythonStyleStringList(String strings) {
        ArrayList<String> parsed = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean reading = false;
        for (char c : strings.substring(1, strings.length() - 1).toCharArray()) {
            switch (c) {
                case '\"' -> {
                    if (reading) {
                        parsed.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    reading = !reading;
                }
                case ',' -> {
                    if (reading) {
                        sb.append(c);
                    }
                }
                default -> sb.append(c);
            }
        }
        return parsed;
    }

    public static String[] parsePythonStyleStringArray(String strings) {
        List<String> parsed = parsePythonStyleStringList(strings);
        String[] res = new String[parsed.size()];
        return parsed.toArray(res);
    }

}
