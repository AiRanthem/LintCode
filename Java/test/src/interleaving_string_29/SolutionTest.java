package test.src.interleaving_string_29;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.interleaving_string_29.Solution;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7ÔÂ 11, 2020</pre>
 */
public class SolutionTest {

    private Solution solution;

    @Before
    public void before() throws Exception {
        solution = new Solution();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isInterleave(String s1, String s2, String s3)
     */
    @Test
    public void testIsInterleave() throws Exception {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        TestCase.assertTrue(solution.isInterleave(s1, s2, s3));

        s1 = "";
        s2 = "";
        s3 = "1";
        TestCase.assertFalse(solution.isInterleave(s1, s2, s3));

        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        TestCase.assertFalse(solution.isInterleave(s1, s2, s3));
    }
} 
