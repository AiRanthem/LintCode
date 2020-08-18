package test.src.sort_list_98; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.sort_list_98.FasterSolution;
import src.utils.RandomListNode;

/**
* FasterSolution Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 16, 2020</pre> 
* @version 1.0 
*/ 
public class FasterSolutionTest { 

private FasterSolution solution;

@Before
public void before() throws Exception {
solution = new FasterSolution(); 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: copyRandomList(RandomListNode head) 
* 
*/ 
@Test
public void testCopyRandomList() throws Exception {
    RandomListNode head = new RandomListNode(-1);
    solution.copyRandomList(head);
} 


} 
