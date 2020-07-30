package test.src.count_of_range_sum_1293; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.count_of_range_sum_1293.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 30, 2020</pre> 
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
* Method: countRangeSum(int[] nums, int lower, int upper) 
* 
*/ 
@Test
public void testCountRangeSum() throws Exception {
    TestCase.assertEquals(3,
            solution.countRangeSum(
                    TestUtil.buildIntArray(-2, 5, -1),
                    -2, 2
            ));
    TestCase.assertEquals(2,
            solution.countRangeSum(
                    TestUtil.buildIntArray(0,-3,-3,1,1,2),
                    3, 5
            ));
}


} 
