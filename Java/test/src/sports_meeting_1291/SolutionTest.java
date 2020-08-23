package test.src.sports_meeting_1291; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.sports_meeting_1291.Solution;
import utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8ÔÂ 23, 2020</pre> 
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
* Method: CheerAll(int[][] Events) 
* 
*/ 
@Test
public void testCheerAll() throws Exception {
    TestCase.assertEquals(-1, solution.CheerAll(
            TestUtil.buildInt2DArray(2, 18,63,31,57,7,8,26,39,33,41,39,75)
    ));
} 


} 
