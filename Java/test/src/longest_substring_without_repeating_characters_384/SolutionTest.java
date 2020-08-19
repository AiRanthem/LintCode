package test.src.longest_substring_without_repeating_characters_384; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.longest_substring_without_repeating_characters_384.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 19, 2020</pre> 
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
* Method: lengthOfLongestSubstring(String s) 
* 
*/ 
@Test
public void testLengthOfLongestSubstring() throws Exception {
    TestCase.assertEquals(7, solution.lengthOfLongestSubstring("bpfbhmipx"));
    TestCase.assertEquals(2, solution.lengthOfLongestSubstring("aab"));
}


} 
