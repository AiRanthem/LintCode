package src.number_of_boomerangs_1237;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int n = solution.numberOfBoomerangs(
                TestUtil.buildInt2DArray(2, 0, 0, 1, 0, 2, 0)
        );
        assertEquals(2, n);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int n = solution.numberOfBoomerangs(
                TestUtil.buildInt2DArray(2, 0, 0, 1, 0, -1, 0, 0, 1, 0, -1)
        );
        System.out.println(n);
    }

    @Test
    public void testFact() {
        Solution solution = new Solution();
        assertEquals(6, solution.fact(3));
        assertEquals(24, solution.fact(4));
        assertEquals(120, solution.fact(5));
    }

}