package test.src.find_peak_element_75;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.TestCase;
import src.find_peak_element_75.Solution;

import java.util.ArrayList;
import java.util.Arrays;
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
     * Method: findPeak(int[] A)
     */
    @Test
    public void testFindPeak() throws Exception {
        int peak = solution.findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6});
        TestCase.assertTrue(buildArray(1, 6).contains(peak));

        int peak1 = solution.findPeak(new int[]{1, 2, 3, 4, 1});
        TestCase.assertEquals(3, peak1);

        int peak2 = solution.findPeak(new int[]{1, 2, 1, 2, 3, 1});
        TestCase.assertTrue(buildArray(1, 4).contains(peak2));
    }


    /**
     * Method: helper(int left, int right)
     */
    @Test
    public void testHelper() throws Exception {
/*
try { 
   Method method = Solution.getClass().getMethod("helper", int.class, int.class); 
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
