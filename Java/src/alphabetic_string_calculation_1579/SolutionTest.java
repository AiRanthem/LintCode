package src.alphabetic_string_calculation_1579;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void kstart() {
        Solution solution = new Solution();
        int aaabbb = solution.Kstart("aaabbb");
        assertEquals(1, aaabbb);

        int abcd = solution.Kstart("abcd");
        assertEquals(3, abcd);
    }
}