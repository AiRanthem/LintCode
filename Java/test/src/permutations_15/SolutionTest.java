package test.src.permutations_15; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.permutations_15.Solution;
import utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 25, 2020</pre> 
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
* Method: permute(int[] nums) 
* 
*/ 
@Test
public void testPermute() throws Exception { 
solution.permute(TestUtil.buildIntArray(1,2,3));
}

} 
