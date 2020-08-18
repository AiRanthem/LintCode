package test.demo; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import demo.Split;
import src.utils.TestUtil;

/**
* Split Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 16, 2020</pre> 
* @version 1.0 
*/ 
public class SplitTest { 

private Split solution;

@Before
public void before() throws Exception {
solution = new Split(); 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: split(String s) 
* 
*/ 
@Test
public void testSplit() throws Exception {
    TestUtil.printStrings(solution.split("ab- c   d  df  ==- g"));
} 


} 
