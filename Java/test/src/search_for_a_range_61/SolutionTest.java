package test.src.search_for_a_range_61; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.search_for_a_range_61.Solution;
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
* Method: searchRange(int[] A, int target) 
* 
*/ 
@Test
public void testSearchRange() throws Exception {
    TestUtil.assertIntArrayEquals(
            TestUtil.buildIntArray(-1,-1),
            solution.searchRange(TestUtil.buildIntArray(),9)
    );

    TestUtil.assertIntArrayEquals(
            TestUtil.buildIntArray(3,4),
            solution.searchRange(TestUtil.buildIntArray(5, 7, 7, 8, 8, 10),8)
    );
} 


} 
