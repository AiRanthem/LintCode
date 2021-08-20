package src.find_nth_digit_1256;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findNthDigit() {
        Solution solution = new Solution();
        assertEquals(3, solution.findNthDigit(3));
        assertEquals(0, solution.findNthDigit(11));
    }

    @Test
    public void findNthDigitErr() {
        Solution solution = new Solution();
        assertEquals(1, solution.findNthDigit(10));
    }

    @Test
    public void findNthDigitErr2() {
        Solution solution = new Solution();
        assertEquals(2, solution.findNthDigit(2147483647));
    }
}