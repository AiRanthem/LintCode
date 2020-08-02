package test.src.lfu_cache_24; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import src.lfu_cache_24.LFUCache;
/** 
* LFUCache Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 1, 2020</pre> 
* @version 1.0 
*/ 
public class LFUCacheTest { 

private LFUCache solution;

@Before
public void before() throws Exception {
solution = new LFUCache(3);
} 

@After
public void after() throws Exception { 
} 

/**
*
* Method: set(int key, int value)
*
*/
@Test
public void testSet() throws Exception {
    solution.set(2,2);
    solution.set(1,1);
    solution.get(2);
    solution.get(1);
    solution.get(2);
    solution.set(3,3);
    solution.set(4,4);
    solution.get(3);
    solution.get(2);
    solution.get(1);
    solution.get(4);
}



} 
