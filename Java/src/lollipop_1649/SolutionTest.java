package src.lollipop_1649;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(30, solution.getAns(15, 20, TestUtil.buildIntArray(4,5,6,10), TestUtil.buildIntArray(2, 1, 30, 31)));
    }

}