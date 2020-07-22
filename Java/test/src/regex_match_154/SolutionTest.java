package test.src.regex_match_154;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.regex_match_154.Solution;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7月 22, 2020</pre>
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
     * Method: isMatch(String s, String p)
     */
    @Test
    public void testIsMatch() throws Exception {
        TestCase.assertFalse(solution.isMatch("aa","a"));
        TestCase.assertFalse(solution.isMatch("aaa","aa"));

        TestCase.assertTrue(solution.isMatch("aa","aa"));
        TestCase.assertTrue(solution.isMatch("aa", "a*"));
        TestCase.assertTrue(solution.isMatch("aa", ".*"));
        TestCase.assertTrue(solution.isMatch("ab", ".*"));
        TestCase.assertTrue(solution.isMatch("aab", "c*a*b"));

        TestCase.assertTrue(solution.isMatch("","a*"));
        TestCase.assertFalse(solution.isMatch("aa",""));

    }

} 
