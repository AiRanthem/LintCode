package src.fetch_supplies_ii_1899;

import org.junit.Test;
import utils.TestUtil;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void fetchSuppliesII() {
        Solution solution = new Solution();
        TestUtil.assertBlurEquals(0.000001, 2, solution.fetchSuppliesII(TestUtil.buildInt2DArray(2, 0, 0, 2, 0, 0, 2)));
    }

}