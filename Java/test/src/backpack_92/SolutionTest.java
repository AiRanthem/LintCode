package test.src.backpack_92; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.backpack_92.Solution;
import src.utils.TestUtil;

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
* Method: backPack(int m, int[] A) 
* 
*/ 
@Test
public void testBackPack() throws Exception {
    TestCase.assertEquals(9, solution.backPack(10,
            TestUtil.buildIntArray(3,4,8,5)
    ));
} 


} 
