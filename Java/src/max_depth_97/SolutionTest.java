package src.max_depth_97;

import org.junit.Test;
import utils.TreeNode;
import utils.TreeUtil;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.deserialize("1,2,3,#,#,4,5");
        assertEquals(3, solution.maxDepth(root));
    }

}