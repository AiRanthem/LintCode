package test.src.first_position_of_target_14; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.first_position_of_target_14.Solution;
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
* Method: binarySearch(int[] nums, int target) 
* 
*/ 
@Test
public void testBinarySearch() throws Exception {
    TestCase.assertEquals(0, solution.binarySearch(
            TestUtil.buildIntArray(1,4,4,5,7,7,8,9,9,10),1
    ));

    TestCase.assertEquals(2, solution.binarySearch(
            TestUtil.buildIntArray(1, 2, 3, 3, 4, 5, 10),3
    ));

    TestCase.assertEquals(-1, solution.binarySearch(
            TestUtil.buildIntArray(1, 2, 3, 3, 4, 5, 10),6
    ));
} 


} 
