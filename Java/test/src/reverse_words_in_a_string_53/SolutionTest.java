package test.src.reverse_words_in_a_string_53; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.reverse_words_in_a_string_53.Solution;
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
* Method: reverseWords(String s) 
* 
*/ 
@Test
public void testReverseWords() throws Exception {
    TestCase.assertEquals("blue is sky the",
            solution.reverseWords("the sky is blue"));

    TestCase.assertEquals("world hello",
            solution.reverseWords("hello world"));

    TestCase.assertEquals("blue is sky the",
            solution.reverseWords("the sky is blue"));

    TestCase.assertEquals("blue",
            solution.reverseWords("blue"));

    TestCase.assertEquals("",
            solution.reverseWords(""));

    TestCase.assertEquals("blue is sky the",
            solution.reverseWords("   the sky is blue"));

    TestCase.assertEquals("blue is sky the",
            solution.reverseWords("the sky is blue    "));

    TestCase.assertEquals("blue is sky the",
            solution.reverseWords("the   sky is  blue"));

    TestCase.assertEquals("blue! is sky? the",
            solution.reverseWords("the sky? is blue!"));
}


} 
