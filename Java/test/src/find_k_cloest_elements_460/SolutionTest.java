package test.src.find_k_cloest_elements_460; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.find_k_cloest_elements_460.Solution;
import utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 29, 2020</pre> 
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
* Method: kClosestNumbers(int[] A, int target, int k) 
* 
*/ 
@Test
public void testKClosestNumbers() throws Exception {
    TestUtil.assertArrayEquals(
            TestUtil.buildIntegerArray(2, 1, 3),
            TestUtil.castInt2IntegerArray(solution.kClosestNumbers(
                    TestUtil.buildIntArray(1,2,3),
                    2,3
            ))
    );

    TestUtil.assertArrayEquals(
            TestUtil.buildIntegerArray(4, 1, 6),
            TestUtil.castInt2IntegerArray(solution.kClosestNumbers(
                    TestUtil.buildIntArray(1, 4, 6, 8),
                    3,3
            ))
    );

    TestUtil.assertArrayEquals(
            TestUtil.buildIntegerArray(20,10,6,4),
            TestUtil.castInt2IntegerArray(solution.kClosestNumbers(
                    TestUtil.buildIntArray(1,4,6,10,20),
                    21,4
            ))
    );
} 


} 
