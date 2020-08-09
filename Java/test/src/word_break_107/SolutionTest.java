package test.src.word_break_107; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import src.utils.TestUtil;
import src.word_break_107.Solution;
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
* Method: wordBreak(String s, Set<String> wordSet) 
* 
*/ 
@Test
public void testWordBreak() throws Exception {
    TestCase.assertTrue(solution.wordBreak("ab",
            TestUtil.buildSet("a", "b")
    ));
}
}
