package test.src.russian_doll_envelopes_602; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.russian_doll_envelopes_602.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 31, 2020</pre> 
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
* Method: maxEnvelopes(int[][] envelopes) 
* 
*/ 
@Test
public void testMaxEnvelopes() throws Exception {
    TestCase.assertEquals(3,
            solution.maxEnvelopes(TestUtil.buildIntXDArray(2, 5,4,6,4,6,7,2,3)));

    TestCase.assertEquals(4,
            solution.maxEnvelopes(TestUtil.buildIntXDArray(2, 4,5,4,6,6,7,2,3,1,1)));
} 


} 
