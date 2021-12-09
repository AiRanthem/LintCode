package src.add_b_label_1127;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void cacuKmpNext() {
        Solution solution = new Solution();
        int[] next = solution.cacuKmpNext("aaaad");
        System.out.println(Arrays.toString(next));
    }
}