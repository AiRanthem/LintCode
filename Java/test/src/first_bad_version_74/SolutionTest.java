package test.src.first_bad_version_74; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.first_bad_version_74.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 5, 2020</pre> 
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
* Method: findFirstBadVersion(int n) 
* 
*/ 
@Test
public void testFindFirstBadVersion() throws Exception {
    TestCase.assertEquals(2147483647, solution.findFirstBadVersion(2147483647));
} 


} 
