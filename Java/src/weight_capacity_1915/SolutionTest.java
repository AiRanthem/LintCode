package src.weight_capacity_1915;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void weightCapacity() {
        SolutionClassic solution = new SolutionClassic();
        assertEquals(6, solution.weightCapacity(TestUtil.buildIntArray(1,3,5), 7));
    }

    @Test
    public void testNew() {
        Solution solution = new Solution();
        assertEquals(6, solution.weightCapacity(TestUtil.buildIntArray(1,3,5), 7));
    }
}