package src.insert_interval_30;

import src.utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class BetterSolution {
    /**
     * 所有原有的interval和要插入的interval有三种关系：
     * 1. 在new后面
     * 2. 在new前面
     * 3. 和new有交集，需要合并
     * a和b有交集的条件是 a.end >= b.start || a.start <= b.end
     * 是一个或关系,所以使用排除法,即 !(a.end < b.start) && !(a.start > b.end)
     * 这样,遍历intervals的时候有三种情况:
     * 1. interval.end < newInterval.start: 前序元素
     * 2. interval.start > newInterval.end: 后续元素
     * 3. else: 有交集
     * 如果有交集的话,则所有有交集的元素加上newInterval,最小的start就是插入元素的start,end同理.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        ArrayList<Interval> res = new ArrayList<>();
        int insert_pos = 0;
        for (Interval interval : intervals) {
            if(interval.end < newInterval.start){
                // 前序元素
                res.add(interval);
                insert_pos++;
            } else if (interval.start > newInterval.end){
                res.add(interval);
            } else {
                if(interval.start < newInterval.start){
                    newInterval.start = interval.start;
                }
                if(interval.end > newInterval.end){
                    newInterval.end = interval.end;
                }
            }
        }
        res.add(insert_pos, newInterval);
        return res;
    }
}
