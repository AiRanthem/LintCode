package src.has_group_size_x_1728;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void hasGroupsSizeX() {
        Solution solution = new Solution();
        assertTrue(solution.hasGroupsSizeX(Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1)));
        assertFalse(solution.hasGroupsSizeX(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3)));
        assertFalse(solution.hasGroupsSizeX(List.of(1)));
        assertTrue(solution.hasGroupsSizeX(Arrays.asList(1, 1, 2, 2, 2, 2)));
        assertTrue(solution.hasGroupsSizeX(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 2, 2)));
    }
}