package test.src.search_in_rotated_sorted_array_62; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.search_in_rotated_sorted_array_62.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 4, 2020</pre> 
* @version 1.0 
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
* 
* Method: search(int[] A, int target) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    TestCase.assertEquals(2, solution.search(
            TestUtil.buildIntArray(4, 5, 1, 2, 3),1
    ));

    TestCase.assertEquals(-1, solution.search(
            TestUtil.buildIntArray(4, 5, 1, 2, 3),0
    ));

    TestCase.assertEquals(4, solution.search(
            TestUtil.buildIntArray(0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1),-9
    ));
} 


} 
