package test.src.valid_number_417; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.valid_number_417.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 13, 2020</pre> 
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
* Method: isNumber(String s) 
* 
*/ 
@Test
public void testIsNumber() throws Exception {
    TestCase.assertFalse(solution.isNumber("."));
    TestCase.assertFalse(solution.isNumber(" "));
    TestCase.assertTrue(solution.isNumber("1 "));
    TestCase.assertFalse(solution.isNumber("1ee4"));
    TestCase.assertFalse(solution.isNumber("e4"));
    TestCase.assertFalse(solution.isNumber("1e"));
    TestCase.assertFalse(solution.isNumber("1e4e1"));
    TestCase.assertTrue(solution.isNumber("1e4"));
    TestCase.assertTrue(solution.isNumber("0"));
    TestCase.assertTrue(solution.isNumber("0.1"));
    TestCase.assertFalse(solution.isNumber("abc"));
    TestCase.assertFalse(solution.isNumber("a 1"));
}


} 
