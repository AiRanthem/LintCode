package test.src.graph_valid_tree_178;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.graph_valid_tree_178.Solution;
import utils.TestUtil;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7月 29, 2020</pre>
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
     * Method: validTree(int n, int[][] edges)
     */
    @Test
    public void testValidTree() throws Exception {
        TestCase.assertTrue(solution.validTree(5,
                TestUtil.buildInt2DArray(2, 0, 1, 0, 2, 0, 3, 1, 4)));

        TestCase.assertFalse(solution.validTree(5,
                TestUtil.buildInt2DArray(2, 0, 1, 1, 2, 2, 3, 1, 3, 1, 4)));

        TestCase.assertFalse(solution.validTree(4,
                TestUtil.buildInt2DArray(2, 0,1,2,3)));

        TestCase.assertFalse(solution.validTree(6,
                TestUtil.buildInt2DArray(2, 0, 1, 0, 2, 3, 4, 3, 5)));

        TestCase.assertTrue(solution.validTree(1,
                TestUtil.buildInt2DArray(2)));

        TestCase.assertFalse(solution.validTree(2,
                TestUtil.buildInt2DArray(2 )));

        TestCase.assertFalse(solution.validTree(10,
                TestUtil.buildInt2DArray(2,0,1,5,6,6,7,9,0,3,7,4,8,1,8,5,2,5,3)));
    }


} 
