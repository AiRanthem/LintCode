package test.src.my_calendar_ii_1064; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.my_calendar_ii_1064.MyCalendarTwo;
/** 
* MyCalendarTwo Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 27, 2020</pre> 
* @version 1.0 
*/ 
public class MyCalendarTwoTest { 

private MyCalendarTwo solution;

@Before
public void before() throws Exception {
solution = new MyCalendarTwo(); 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: book(int start, int end) 
* 
*/ 
@Test
public void testBook() throws Exception {
    TestCase.assertTrue(solution.book(10, 20)); // 返回true
    TestCase.assertTrue(solution.book(50, 60)); // 返回true
    TestCase.assertTrue(solution.book(10, 40)); // 返回true
    TestCase.assertFalse(solution.book(5, 15)); // 返回false
    TestCase.assertTrue(solution.book(5, 10)); // 返回true
    TestCase.assertTrue(solution.book(25, 55)); //返回true
} 


} 
