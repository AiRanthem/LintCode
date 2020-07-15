package test.src.stat_number_3; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import junit.framework.TestCase;
import src.stat_number_3.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 14, 2020</pre> 
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
* Method: digitCounts(int k, int n) 
* 
*/ 
@Test
public void testDigitCounts() throws Exception { 
    TestCase.assertEquals(1, solution.digitCounts(1, 1));
    TestCase.assertEquals(5, solution.digitCounts(1, 12));
    TestCase.assertEquals(3, solution.digitCounts(0, 20));
    TestCase.assertEquals(1, solution.digitCounts(0, 0));
    TestCase.assertEquals(0, solution.digitCounts(1, 0));
} 


} 
