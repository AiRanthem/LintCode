package test.src.bomb_attack_553;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.bomb_attack_553.Solution;
import src.utils.TestUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7ÔÂ 14, 2020</pre>
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
     * Method: maxKilledEnemies(char[][] grid)
     */
    @Test
    public void testMaxKilledEnemies() throws Exception {
        char[][] input = TestUtil.buildCharGrid("0E00",
                "E0WE",
                "0E00");
        TestCase.assertEquals(3, solution.maxKilledEnemies(input));

        input = TestUtil.buildCharGrid("0E00",
                "EEWE",
                "0E00");
        TestCase.assertEquals(2, solution.maxKilledEnemies(input));

        input = TestUtil.buildCharGrid("",
                "",
                "");
        TestCase.assertEquals(0, solution.maxKilledEnemies(input));

        input = TestUtil.buildCharGrid();
        TestCase.assertEquals(0, solution.maxKilledEnemies(input));

        input = TestUtil.buildCharGrid();
        TestCase.assertEquals(0, solution.maxKilledEnemies(input));

        input = TestUtil.buildCharGrid("W00000EEEEEEEE000000WWW0WWW00W0W0WEEEE0000EW00W");
        TestCase.assertEquals(8, solution.maxKilledEnemies(input));

        input = TestUtil.buildCharGrid("E", "E", "E", "W", "E", "E", "0", "E", "E", "W", "E", "0");
        TestCase.assertEquals(4, solution.maxKilledEnemies(input));
    }


} 
