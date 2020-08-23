package test.src.split_string_680; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.split_string_680.Solution;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 16, 2020</pre> 
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
* Method: splitString(String s) 
* 
*/ 
@Test
public void testSplitString() throws Exception {
    solution.splitString("12321");
}

} 
