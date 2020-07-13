package test.src.plus_one_407;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.plus_one_407.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7ÔÂ 13, 2020</pre>
 */
public class SolutionTest<T> {

    private Solution solution;

    @SafeVarargs
    private <T> List<T> buildList(T... elements) {
        ArrayList<T> ts = new ArrayList<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }

    private int[] buildIntArray(int... elements) {
        return elements;
    }

    private <T> void assertArrayEquals(T[] input, T[] expected){
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

    private void assertIntArrayEquals(int[] input, int[] expected){
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

    @Before
    public void before() throws Exception {
        solution = new Solution();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: plusOne(int[] digits)
     */
    @Test
    public void testPlusOne() throws Exception {
        int[] input = buildIntArray(1, 2, 3);
        int[] expect = buildIntArray(1, 2, 4);
        assertIntArrayEquals(solution.plusOne(input), expect);

        input = buildIntArray(9, 9, 9);
        expect = buildIntArray(1, 0, 0, 0);
        assertIntArrayEquals(solution.plusOne(input), expect);
    }
} 
