package src.my_calendar_ii_1064;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

    /**
     * 思路：
     * 先把当前事件加入，按照时间顺序遍历时间轴，如果发现有活动start，则活动数+1，有活动end，则活动数-1
     * 遍历过程中如果活动数>=3，则有 三重预定，返回false，回滚事件，否则返回true。
     * <p>
     * 实现：
     * 这个map的key是时间点，value是改时间点发生的活动数变化
     * TreeMap按照key排序，则意味着遍历这个集合可以按照时间（key）顺序遍历
     * 活动数发生两次改变之间不会变化，所以只要遍历start和end的时间节点即可
     */
    private TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // 加入事件
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        // 遍历检查时间轴
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            if(cnt > 2){
                // 发现三重预定，回滚事件，返回false
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }

        // 检查无误，返回true
        return true;
    }
}
