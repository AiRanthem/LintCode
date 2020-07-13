package test.src.longest_increasing_subsequence_76;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.longest_increasing_subsequence_76.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
     * Method: longestIncreasingSubsequence(int[] nums)
     */
    @Test
    public void testLongestIncreasingSubsequence() throws Exception {
        TestCase.assertEquals(3, solution.longestIncreasingSubsequence(new int[]{5, 4, 1, 2, 3}));
        TestCase.assertEquals(4, solution.longestIncreasingSubsequence(new int[]{4, 2, 4, 5, 3, 7}));
        TestCase.assertEquals(1, solution.longestIncreasingSubsequence(new int[]{1,1,1,1,1,1,1}));
    }


    /**
     * Method: longestSameSubsequence(int[] a, int[] b)
     */
    @Test
    public void testLongestSameSubsequence() throws Exception {
/*
try { 
   Method method = Solution.getClass().getMethod("longestSameSubsequence", int[].class, int[].class); 
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
