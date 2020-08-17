package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int solute(int[] rank, int left, int right, int smallest_bullets) {
        if (left > right) return 0;
        int min = rank[0];
        int idx = 0;
        // find min
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] < min){
                min = rank[i];
                idx = i;
            }
        }
        // give him
        return smallest_bullets + solute(rank, left, idx-1, smallest_bullets+1) +
                solute(rank, idx+1, right, smallest_bullets+1);
    }
}
