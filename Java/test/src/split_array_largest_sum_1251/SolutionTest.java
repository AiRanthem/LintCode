package test.src.split_array_largest_sum_1251; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.split_array_largest_sum_1251.Solution;
import utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 11, 2020</pre> 
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
* Method: splitArray(int[] nums, int m) 
* 
*/ 
@Test
public void testSplitArray() throws Exception {
    TestCase.assertEquals(25, solution.splitArray(
            TestUtil.buildIntArray(10,5,13,4,8,4,5,11,14,9,16,10,20,8), 8
    ));

    TestCase.assertEquals(18, solution.splitArray(
            TestUtil.buildIntArray(7,2,5,10,8), 2
    ));

    TestCase.assertEquals(4, solution.splitArray(
            TestUtil.buildIntArray(1,4,4), 3
    ));
} 


} 
