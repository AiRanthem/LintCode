package test.src.find_minimun_in_rotated_sorted_array_159; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.find_minimun_in_rotated_sorted_array_159.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 5, 2020</pre> 
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
* Method: findMin(int[] nums) 
* 
*/ 
@Test
public void testFindMin() throws Exception {
    TestCase.assertEquals(0, solution.findMin(
            TestUtil.buildIntArray(4, 5, 6, 7, 0, 1, 2)
    ));

    TestCase.assertEquals(1, solution.findMin(
            TestUtil.buildIntArray(2,1)
    ));

    TestCase.assertEquals(2, solution.findMin(
            TestUtil.buildIntArray(2)
    ));
} 


} 
