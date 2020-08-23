package test.src.anagrams_171; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.anagrams_171.Solution;
import utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8ÔÂ 9, 2020</pre> 
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
* Method: anagrams(String[] strs) 
* 
*/ 
@Test
public void testAnagrams() throws Exception {
    TestUtil.assertListEquals(
            TestUtil.buildList("lint", "inlt", "intl"),
            solution.anagrams(TestUtil.buildArray("lint", "intl", "inlt", "code"))
    );
}


} 
