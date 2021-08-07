package src.check_record_1178;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertTrue(solution.checkRecord("PPALLP"));
        assertFalse(solution.checkRecord("PPALLL"));
        assertTrue(solution.checkRecord("LALL"));
    }
}