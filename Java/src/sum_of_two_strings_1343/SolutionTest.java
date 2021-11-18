package src.sum_of_two_strings_1343;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sumofTwoStrings() {
        Solution solution = new Solution();
        assertEquals("11010", solution.SumofTwoStrings("99", "111"));
        assertEquals("323", solution.SumofTwoStrings("321", "2"));
    }
}