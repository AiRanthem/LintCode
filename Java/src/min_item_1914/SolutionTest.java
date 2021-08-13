package src.min_item_1914;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minItem() {
        Solution solution = new Solution();
        assertEquals(2, solution.minItem(Arrays.asList(2, 2, 3, 1, 1, 1), 2));
    }
}