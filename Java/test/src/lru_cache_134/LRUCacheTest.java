package test.src.lru_cache_134;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.lru_cache_134.LRUCache;

/**
 * LRUCache Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>8月 2, 2020</pre>
 */
public class LRUCacheTest {

    private LRUCache solution;

    @Before
    public void before() throws Exception {
        solution = new LRUCache(1);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get(int key)
     */
    @Test
    public void testGet() throws Exception {
        solution.set(2,1);
        TestCase.assertEquals(1, solution.get(2));
        solution.set(3,2);
        TestCase.assertEquals(-1, solution.get(2));
        TestCase.assertEquals(2, solution.get(3));

    }

} 
