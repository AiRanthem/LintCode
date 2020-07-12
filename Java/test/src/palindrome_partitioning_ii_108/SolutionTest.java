package test.src.palindrome_partitioning_ii_108;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.palindrome_partitioning_ii_108.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>7ÔÂ 12, 2020</pre>
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
     * Method: minCut(String s)
     */
    @Test
    public void testMinCut() throws Exception {
        TestCase.assertEquals(0, solution.minCut(""));
        TestCase.assertEquals(0, solution.minCut("a"));
        TestCase.assertEquals(0, solution.minCut("aa"));
        TestCase.assertEquals(0, solution.minCut("aaa"));
        TestCase.assertEquals(0, solution.minCut("aaaa"));
        TestCase.assertEquals(0, solution.minCut("aba"));
        TestCase.assertEquals(0, solution.minCut("abba"));
        TestCase.assertEquals(0, solution.minCut("abbba"));
        TestCase.assertEquals(0, solution.minCut("ababa"));
        TestCase.assertEquals(1, solution.minCut("aab"));
        TestCase.assertEquals(1, solution.minCut("aaab"));
        TestCase.assertEquals(1, solution.minCut("abab"));
        TestCase.assertEquals(1, solution.minCut("acab"));
        TestCase.assertEquals(1, solution.minCut("baa"));
        TestCase.assertEquals(1, solution.minCut("baaa"));
        TestCase.assertEquals(1, solution.minCut("baca"));
        TestCase.assertEquals(1, solution.minCut("abcccb"));
        TestCase.assertEquals(2, solution.minCut("abbc"));
        TestCase.assertEquals(2, solution.minCut("abbbc"));
        TestCase.assertEquals(2, solution.minCut("abdbc"));
    }


    /**
     * Method: isPalindrome(String s)
     */
    @Test
    public void testIsPalindrome() throws Exception {
        //TODO: Test goes here...
/* 
try { 
   Method method = Solution.getClass().getMethod("isPalindrome", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    @SafeVarargs
    private <T> List<T> buildArray(T... elements) {
        ArrayList<T> ts = new ArrayList<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }
} 
