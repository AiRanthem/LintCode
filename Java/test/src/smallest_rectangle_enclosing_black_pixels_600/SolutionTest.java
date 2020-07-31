package test.src.smallest_rectangle_enclosing_black_pixels_600; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.smallest_rectangle_enclosing_black_pixels_600.Solution;
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
* Method: minArea(char[][] image, int x, int y) 
* 
*/ 
@Test
public void testMinArea() throws Exception {
    TestCase.assertEquals(6, solution.minArea(
            TestUtil.buildCharGrid("0010","0110","0100"),
            0, 2
    ));

    TestCase.assertEquals(6, solution.minArea(
            TestUtil.buildCharGrid("1110","1100","0000","0000"),
            0, 1
    ));
}

} 
