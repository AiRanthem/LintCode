package src.terminate_process_872;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void testKillProcess() {
        Solution solution = new Solution();
        List<Integer> pid = solution.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5);
        System.out.println(pid);
    }
}