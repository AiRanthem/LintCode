package src.merge_intervals_156;

import src.utils.Interval;

import java.util.*;
import java.util.List;

public class Solution {
    /**
     * @param intervals: interval list.
     * @return A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            for (int j = i; j < intervals.size(); j++) {
                Interval next = intervals.get(j);
                if (interval.end >= next.start) {
                    interval.end = Math.max(interval.end, next.end);
                } else break;
                i = j;
            }
            result.add(interval);
        }
        return result;
    }
}
