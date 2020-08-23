package test.src.binary_search_tree_iterator_86;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.binary_search_tree_iterator_86.BSTIterator;
import utils.TreeNode;
import utils.TreeUtil;

/**
 * BSTIterator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>8月 2, 2020</pre>
 */
public class BSTIteratorTest {

    private BSTIterator solution;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: hasNext()
     */
    @Test
    public void testHasNext() throws Exception {
        TreeNode deserialize = TreeUtil.deserialize("10,1,11,#,6,#,12");
        solution = new BSTIterator(deserialize);
        TestCase.assertEquals(1, solution.next().val);
        TestCase.assertEquals(6, solution.next().val);
        TestCase.assertEquals(10, solution.next().val);
        TestCase.assertEquals(11, solution.next().val);
        TestCase.assertEquals(12, solution.next().val);
    }
} 

