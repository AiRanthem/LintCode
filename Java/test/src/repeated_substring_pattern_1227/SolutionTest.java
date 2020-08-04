package test.src.repeated_substring_pattern_1227; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.repeated_substring_pattern_1227.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 3, 2020</pre> 
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
* Method: repeatedSubstringPattern(String s) 
* 
*/ 
@Test
public void testRepeatedSubstringPattern() throws Exception {
    TestCase.assertTrue(solution.repeatedSubstringPattern("abab"));
    TestCase.assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
    TestCase.assertFalse(solution.repeatedSubstringPattern("aba"));
    TestCase.assertFalse(solution.repeatedSubstringPattern("babbbbaabbababbaaaaababbaaabbbbaaabbbababbbbabaabababaabaaabbbabababbbabababaababaaaaabbabaaaabaaaab"));
    // babbbbaabbababbaaaaababbaaabbbbaaabbbababbbbabaaba
    // babaabaaabbbabababbbabababaababaaaaabbabaaaabaaaab
} 


} 
