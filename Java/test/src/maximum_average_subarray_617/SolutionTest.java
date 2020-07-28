package test.src.maximum_average_subarray_617; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.maximum_average_subarray_617.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 28, 2020</pre> 
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
* Method: maxAverage(int[] nums, int k) 
* 
*/ 
@Test
public void testMaxAverage() throws Exception {
    TestUtil.assertBlurEquals(0.001, 15.667,
            solution.maxAverage(TestUtil.buildIntArray(1,12,-5,-6,50,3), 3));

    TestUtil.assertBlurEquals(0.001, 5,
            solution.maxAverage(TestUtil.buildIntArray(5), 1));
} 

/** 
* 
* Method: ansGreaterThan(double avg) 
* 
*/ 
@Test
public void testAnsGreaterThan() throws Exception { 
//TODO: Test goes here... 
} 


} 
