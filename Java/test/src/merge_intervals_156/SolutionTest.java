package test.src.merge_intervals_156;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.merge_intervals_156.Solution;
import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7�� 13, 2020</pre>
 */
public class SolutionTest {

    private Solution solution;

    @SafeVarargs
    private <T> List<T> buildArray(T... elements) {
        ArrayList<T> ts = new ArrayList<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }

    @Before
    public void before() throws Exception {
        solution = new Solution();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: merge(List<Interval> intervals)
     */
    @Test
    public void testMerge() throws Exception {
        ArrayList<Interval> input = new ArrayList<>();
        ArrayList<Interval> expect = new ArrayList<>();

        expect.clear();
        input.clear();
        input.add(new Interval(1,3));
        input.add(new Interval(2,6));
        input.add(new Interval(8,10));
        input.add(new Interval(15,18));

        expect.add(new Interval(1, 6));
        expect.add(new Interval(8,10));
        expect.add(new Interval(15,18));

        TestCase.assertEquals(expect, solution.merge(input));
    }


} 
