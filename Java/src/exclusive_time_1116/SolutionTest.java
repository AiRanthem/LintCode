package src.exclusive_time_1116;

import org.junit.Test;
import utils.TestUtil;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] ans = solution.exclusiveTime(2, Arrays.asList(
                "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"
        ));
        assertArrayEquals(TestUtil.buildIntArray(3, 4), ans);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        assertArrayEquals(TestUtil.buildIntArray(1, 1, 2), solution.exclusiveTime(3, Arrays.asList(
                "0:start:0",
                "0:end:0",
                "1:start:1",
                "1:end:1",
                "2:start:2",
                "2:end:2",
                "2:start:3",
                "2:end:3")
        ));
    }

}