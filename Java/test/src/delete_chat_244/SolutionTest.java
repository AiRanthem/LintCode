package test.src.delete_chat_244; 

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import src.delete_chat_244.Solution;
/** 
* Solution Tester. 
* 
* @author <Authors name> 
* @since <pre>8ÔÂ 12, 2020</pre> 
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
* Method: deleteChar(String str, int k) 
* 
*/ 
@Test
public void testDeleteChar() throws Exception {
    TestCase.assertEquals("ab", solution.deleteChar("fskacsbi", 2));
    TestCase.assertEquals("aac", solution.deleteChar("fsakbacsi", 3));
    TestCase.assertEquals("aaggcfvqlxtsbbtbvifajznyvldhgqaumqikafzpwqclanrzpqnijusmarxqfntll",
            solution.deleteChar(
                    "tjvzieuxvwuomxipjajasjoknjzkljuzgsjtghjcfvqlxtsbbtbvifajznyvldhgqaumqikafzpwqclanrzpqnijusmarxqfntll",
                    65
            ));

}


} 
