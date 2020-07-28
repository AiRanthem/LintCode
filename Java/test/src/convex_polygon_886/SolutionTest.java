package test.src.convex_polygon_886; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.convex_polygon_886.Solution;
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
* Method: isConvex(int[][] point) 
* 
*/ 
@Test
public void testIsConvex() throws Exception {
    TestCase.assertFalse(solution.isConvex(
            TestUtil.buildIntXDArray(2, 0, 0, 1, 0, 2, 0, 3,0,4,0,5,0,5,3,2,3,1,4)
    ));
} 


} 
