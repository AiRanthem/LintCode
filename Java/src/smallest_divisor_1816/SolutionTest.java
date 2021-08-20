package src.smallest_divisor_1816;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void smallestDivisor() {
        Solution solution = new Solution();
        assertEquals(5, solution.smallestDivisor(TestUtil.buildIntArray(1, 2, 5, 9), 6));
        assertEquals(3, solution.smallestDivisor(TestUtil.buildIntArray(2, 3, 4, 7, 11), 11));
        assertEquals(4, solution.smallestDivisor(TestUtil.buildIntArray(19), 5));

    }
}