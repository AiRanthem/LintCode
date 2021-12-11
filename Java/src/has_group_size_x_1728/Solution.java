package src.has_group_size_x_1728;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    /**
     * @param deck: a integer array
     * @return: return a value of bool
     */
    public boolean hasGroupsSizeX(List<Integer> deck) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (Integer card : deck) {
            counter.compute(card, (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> counted = counter.values().stream().distinct().sorted().collect(Collectors.toList());
        for (int i = 2; i <= counted.get(0); i++) {
            int finalI = i;
            if (counted.stream().noneMatch(x -> x % finalI != 0)) {
                return true;
            }
        }
        return false;
    }
}
