package src.trangle_minimum_total_109;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minimumTotal() {
        Solution solution = new Solution();
        assertEquals(11, solution.minimumTotal(TestUtil.buildInt2DArray( 4,
            2, 0, 0, 0,
                3, 4, 0, 0,
                6, 5, 7, 0,
                4, 1, 8, 3
        )));
        assertEquals(12, solution.minimumTotal(TestUtil.buildInt2DArray( 4,
                2, 0, 0, 0,
                3, 2, 0, 0,
                6, 5, 7, 0,
                4, 4, 8, 1
        )));
    }

    @Test
    public void errorTEst() {
        Solution solution = new Solution();
        assertEquals(-1, solution.minimumTotal(TestUtil.buildInt2DArray( 3,
                -1, 0, 0,
                2, 3, 0,
                1, -1, -3
        )));
    }
}