package test.src.longest_consecutive_sequence_124; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.longest_consecutive_sequence_124.Solution;
import utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 15, 2020</pre> 
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
* Method: longestConsecutive(int[] num) 
* 
*/ 
@Test
public void testLongestConsecutive() throws Exception {
    TestCase.assertEquals(4, solution.longestConsecutive(
            TestUtil.buildIntArray(100, 4, 200, 1, 3, 2)
    ));
} 


} 
