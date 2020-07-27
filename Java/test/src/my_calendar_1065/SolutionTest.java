package test.src.my_calendar_1065;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.my_calendar_1065.Solution;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7月 27, 2020</pre>
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

    @Test
    public void test() throws Exception{
        TestCase.assertTrue(solution.book(10, 20));
        TestCase.assertFalse(solution.book(15, 25));
        TestCase.assertTrue(solution.book(20, 30));
    }

    @Test public void test2() throws Exception{
        TestCase.assertTrue(solution.book(12,20));
        TestCase.assertTrue(solution.book(1,2));
    }

} 
