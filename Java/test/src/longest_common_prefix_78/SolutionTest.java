package test.src.longest_common_prefix_78; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.longest_common_prefix_78.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 6, 2020</pre> 
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
* Method: longestCommonPrefix(String[] strs) 
* 
*/ 
@Test
public void testLongestCommonPrefix() throws Exception {
    TestCase.assertEquals("A", solution.longestCommonPrefix(
            TestUtil.buildArray("ABCD", "ABEF", "ACEF")
    ));

    TestCase.assertEquals("ABC", solution.longestCommonPrefix(
            TestUtil.buildArray("ABCDEFG", "ABCEFG", "ABCEFA")
    ));

    TestCase.assertEquals("", solution.longestCommonPrefix(
            TestUtil.buildArray("", "ABEF", "ACEF")
    ));

    TestCase.assertEquals("", solution.longestCommonPrefix(
            TestUtil.buildArray("")
    ));

    TestCase.assertEquals("ABC", solution.longestCommonPrefix(
            TestUtil.buildArray("ABC")
    ));
} 


} 
