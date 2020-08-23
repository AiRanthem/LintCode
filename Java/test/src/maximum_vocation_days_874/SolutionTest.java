package test.src.maximum_vocation_days_874;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.maximum_vocation_days_874.Solution;
import utils.TestUtil;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7月 30, 2020</pre>
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
     * Method: maxVacationDays(int[][] flights, int[][] days)
     */
    @Test
    public void testMaxVacationDays() throws Exception {
        TestCase.assertEquals(12, solution.maxVacationDays(
                TestUtil.buildInt2DArray(3, 0, 1, 1, 1, 0, 1, 1, 1, 0),
                TestUtil.buildInt2DArray(3, 1, 3, 1, 6, 0, 3, 3, 3, 3)
        ));
    }

    @Test
    public void test() throws Exception {
        TestCase.assertEquals(3, solution.maxVacationDays(
                TestUtil.buildInt2DArray(3, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                TestUtil.buildInt2DArray(3, 1, 1, 1, 7, 7, 7, 7, 7, 7)
        ));
    }

    @Test
    public void test1() throws Exception {
        TestCase.assertEquals(21, solution.maxVacationDays(
                TestUtil.buildInt2DArray(3, 0, 1, 1, 1, 0, 1, 1, 1, 0),
                TestUtil.buildInt2DArray(3, 7, 0, 0, 0, 7, 0, 0, 0, 7)
        ));
    }

    @Test
    public void test2() throws Exception {
        TestCase.assertEquals(7, solution.maxVacationDays(
                TestUtil.buildInt2DArray(3, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                TestUtil.buildInt2DArray(3, 0, 0, 7, 2, 0, 0, 7, 7, 7)
        ));
    }


} 
