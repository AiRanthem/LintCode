package src.buttom_left_value_1197;

import org.junit.Test;
import utils.TreeUtil;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findBottomLeftValue() {
        Solution solution = new Solution();
        assertEquals(1, solution.findBottomLeftValue(TreeUtil.deserialize("2,1,3")));
    }

    @Test
    public void findBottomLeftValue2() {
        Solution solution = new Solution();
        assertEquals(7, solution.findBottomLeftValue(TreeUtil.deserialize("1,2,3,4,5,6,#,#,7")));
    }
}