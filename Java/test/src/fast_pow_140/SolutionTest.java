package test.src.fast_pow_140;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.fast_pow_140.Solution;

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
public class SolutionTest {

    private Solution solution;

    @Before
    public void before() throws Exception {
        solution = new Solution();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: fastPower(int a, int b, int n)
     */
    @Test
    public void testFastPower() throws Exception {
        TestCase.assertEquals(2, solution.fastPower(2, 3, 31));
        TestCase.assertEquals(0, solution.fastPower(100, 1000, 1000));

        // a: 0, 1, >1
        // b: 0, 1, >1
        // n: 0, 1, >1
        // test a
        TestCase.assertEquals(0, solution.fastPower(0, 3, 3));
        TestCase.assertEquals(1, solution.fastPower(1, 3, 3));
        // test b
        TestCase.assertEquals(0, solution.fastPower(3, 0, 3));
        TestCase.assertEquals(0, solution.fastPower(3, 1, 0));
        // test n
        TestCase.assertEquals(1, solution.fastPower(3, 3, 0));
        TestCase.assertEquals(0, solution.fastPower(3, 3, 1));

        // not found
        TestCase.assertEquals(78433, solution.fastPower(11, 123898, 12345));
    }


} 
