package test.src.bulb_switcher_991; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import junit.framework.TestCase;
import src.bulb_switcher_991.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>7ÔÂ 14, 2020</pre> 
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
* Method: bulbSwitch(int n) 
* 
*/ 
@Test
public void testBulbSwitch() throws Exception { 
    TestCase.assertEquals(1, solution.bulbSwitch(3));
    TestCase.assertEquals(1, solution.bulbSwitch(2));
    TestCase.assertEquals(2, solution.bulbSwitch(5));
    TestCase.assertEquals(3, solution.bulbSwitch(10));
} 


} 
