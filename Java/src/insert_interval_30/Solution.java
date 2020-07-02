package src.insert_interval_30;


import src.utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private Interval toInsert;
    private List<Interval> left;
    private List<Interval> right;
    private List<Interval> intervals;

    /**
     * @param intervals:   Sorted interval list.
     * @param newInterval: new interval.
     * @return A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        this.toInsert = newInterval;
        this.intervals = intervals;
        left = new ArrayList<>();
        right = new ArrayList<>();
        Integer index = null;

        for (int i = 0; i < size; i++) {
            Interval cur = intervals.get(i);
            // insert here at position i
            if (toInsert.start <= cur.start) {
                Interval before = (i > 0) ? intervals.get(i - 1) : null;
                // deal with before
                if (before != null) {
                    mergeBefore(before, i - 1);
                }
                // deal with current
                // whether should merge with right?
                if (cur.start <= toInsert.end) {
                    // find the last interval to be merged
                    right.add(cur);
                    for (int j = i + 1; j < size; j++) {
                        cur = intervals.get(j);
                        if (cur.start <= toInsert.end) {
                            right.add(cur);
                        } else {
                            // roll back
                            cur = right.get(right.size()-1);
                            break;
                        }
                    }
                    // set end
                    if (toInsert.end < cur.end) {
                        toInsert.end = cur.end;
                    }
                }
                index = i;
                break;
            }
        }
        if (index == null) {
            index = size;
            mergeBefore(intervals.get(size - 1), size - 1);
        }
        intervals.add(index, toInsert);
        for (Interval interval : left) {
            intervals.remove(interval);
        }
        for (Interval interval : right) {
            intervals.remove(interval);
        }
        return intervals;
    }

    private void mergeBefore(Interval before, int pos) {
        // whether it needs to merge
        if (toInsert.start <= before.end) {
            // find the first interval to merge
            left.add(before);
            for (int i = pos - 1; i >= 0; i--) {
                before = intervals.get(i);
                if(toInsert.start <= before.end){
                    left.add(before);
                } else {
                    // roll back
                    before = left.get(left.size()-1);
                    break;
                }
            }
            // set start
            toInsert.start = before.start;
            if (toInsert.end < before.end) {
                toInsert.end = before.end;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        List<Interval> insert = solution.insert(intervals, new Interval(0, 11));
        for (Interval interval : insert) {
            System.out.println("interval = " + interval);
        }
    }
}
