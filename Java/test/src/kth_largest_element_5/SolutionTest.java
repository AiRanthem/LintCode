package test.src.kth_largest_element_5; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.kth_largest_element_5.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 16, 2020</pre> 
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
* Method: kthLargestElement(int n, int[] nums) 
* 
*/ 
@Test
public void testKthLargestElement() throws Exception {
    TestCase.assertEquals(4, solution.kthLargestElement(
            3, TestUtil.buildIntArray(9,3,2,4,8)));
} 

/** 
* 
* Method: quickSelect(int start, int end, int n) 
* 
*/ 
@Test
public void testQuickSelect() throws Exception { 
//TODO: Test goes here... 
} 


} 
