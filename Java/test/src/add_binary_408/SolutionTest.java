package test.src.add_binary_408; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.add_binary_408.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8ÔÂ 31, 2020</pre> 
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
* Method: addBinary(String a, String b) 
* 
*/ 
@Test
public void testAddBinary() throws Exception {
    TestCase.assertEquals("100", solution.addBinary("10", "10"));
} 



} 
