package src.put_balls_1904;

import org.junit.Test;
import utils.TestUtil;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(0, solution.getAns(5, 6, TestUtil.buildList(1, 2, 3, 4, 5), TestUtil.buildList(15, 15, 15, 15, 15)));
    }

}