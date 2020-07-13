package test.src.paint_fence_514; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import junit.framework.TestCase;
import src.paint_fence_514.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 13, 2020</pre> 
* @version 1.0 
*/ 
public class SolutionTest { 

private Solution solution;

    @SafeVarargs
    private <T> List<T> buildList(T... elements) {
        ArrayList<T> ts = new ArrayList<>(elements.length);
        Collections.addAll(ts, elements);
        return ts;
    }

    private int[] buildIntArray(int... elements) {
        return elements;
    }

    private <T> void assertArrayEquals(T[] input, T[] expected){
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }
    
    private void assertIntArrayEquals(int[] input, int[] expected){
        for (int i = 0; i < input.length; i++) {
            TestCase.assertEquals(expected[i], input[i]);
        }
    }

@Before
public void before() throws Exception { 
    solution = new Solution();
} 

@After
public void after() throws Exception { 
}

/** 
* 
* Method: numWays(int n, int k) 
* 
*/ 
@Test
public void testNumWays() throws Exception {
    TestCase.assertEquals(6, solution.numWays(3, 2));
    TestCase.assertEquals(4, solution.numWays(2, 2));
    TestCase.assertEquals(2, solution.numWays(1, 2));
} 


} 
