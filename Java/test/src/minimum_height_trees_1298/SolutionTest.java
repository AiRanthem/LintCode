package test.src.minimum_height_trees_1298; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.minimum_height_trees_1298.Solution;
import src.utils.TestUtil;

/**
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 27, 2020</pre> 
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
* Method: findMinHeightTrees(int n, int[][] edges) 
* 
*/ 
@Test
public void testFindMinHeightTrees() throws Exception {
    TestUtil.assertListEquals(TestUtil.buildList(1),
            solution.findMinHeightTrees(4, TestUtil.buildIntXDArray(2, 1,0,1,2,1,3)));
    TestUtil.assertListEquals(TestUtil.buildList(3,4),
            solution.findMinHeightTrees(6, TestUtil.buildIntXDArray(2, 0, 3, 1, 3, 2, 3, 4, 3, 5, 4)));
} 


} 
