package test.src.sqrt_x_141; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.sqrt_x_141.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 18, 2020</pre> 
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
* Method: sqrt(int x) 
* 
*/ 
@Test
public void testSqrt() throws Exception {
    TestCase.assertEquals(256, solution.sqrt(65536));
} 


} 
