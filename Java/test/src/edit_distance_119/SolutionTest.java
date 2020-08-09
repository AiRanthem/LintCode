package test.src.edit_distance_119; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.edit_distance_119.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8ÔÂ 9, 2020</pre> 
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
* Method: minDistance(String word1, String word2) 
* 
*/ 
@Test
public void testMinDistance() throws Exception {
    TestCase.assertEquals(3, solution.minDistance("horse","ros"));

    TestCase.assertEquals(5, solution.minDistance("intention","execution"));

    TestCase.assertEquals(200, solution.minDistance("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
} 


} 
