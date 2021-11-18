package src.recover_rotated_sorted_array_39;

import org.junit.Test;
import utils.TestUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void recoverRotatedSortedArray() throws Exception {
        Solution solution = new Solution();
        List<Integer> nums = TestUtil.buildList(4, 5, 1, 2, 3);
        solution.recoverRotatedSortedArray(nums);
        TestUtil.assertListEquals(Arrays.asList(1, 2, 3, 4, 5), nums);
    }

    @Test
    public void idxMin() {
        Solution solution = new Solution();
        assertEquals(0, solution.idxMin(Arrays.asList(1, 2, 3, 4, 5), 0, 4));
        assertEquals(4, solution.idxMin(Arrays.asList(2, 3, 4, 5, 1), 0, 4));
        assertEquals(3, solution.idxMin(Arrays.asList(3, 4, 5, 1, 2), 0, 4));
        assertEquals(2, solution.idxMin(Arrays.asList(4, 5, 1, 2, 3), 0, 4));
        assertEquals(1, solution.idxMin(Arrays.asList(5, 1, 2, 3, 4), 0, 4));
        assertEquals(9, solution.idxMin(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 0, 20));
    }
}