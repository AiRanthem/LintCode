package src.sports_meeting_1291;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    /**
     * 贪心法：按照最晚参与时刻排序，以此看当前时间能否参加
     * 设 l = 最晚参与时刻；d = 活动耗费时间。最晚参与时刻当时包括在活动耗费时间中。
     * 贪心证明：要证 如果能够cheer all，那么一定有一个结果序列是按照最晚参与时间排序的。
     * 假设有一个结果序列，不是按照最晚参与时间排序，则假设活动1和活动2满足:
     * 活动1先于活动2发生，但是l2 < l1，设活动1的实际发生时间为t，则有
     * t + d1 < l2 < l1 => t < l1
     * ∵ t < l1 ∴ t时刻可以进行活动1
     * ∵ t + d1 < l2 ∴ t时刻进行活动1后，还可以进行活动2
     * 综上，活动1和活动2的发生次序可以调换
     * 该结论具有一般性，因此认为结果序列中，可以调整为按照最晚发生时间升序排列。
     * @param Events: the start and end time
     * @return: if there has a solution return 1, otherwise return -1.
     */
    public int CheerAll(int[][] Events) {
        ArrayList<Event> events = new ArrayList<>(Events.length);
        for (int[] event : Events) {
            events.add(new Event(event));
        }
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o1.latest_participate_time, o2.latest_participate_time);
            }
        });
        int cur = 1;
        for (Event event : events) {
            if (cur > event.latest_participate_time) return -1;
            if (cur < event.start_time) cur = event.start_time + event.dur_time;
            else cur += event.dur_time;
        }
        return 1;
    }
}

class Event{
    public int latest_participate_time; // 最晚参与活动时间
    public int dur_time; // 需要在这个活动中耗费的时间
    public int start_time; // 活动开始时间
    public Event(int[] event){
        dur_time = (event[1] - event[0]) / 2 + 1;
        latest_participate_time = event[1] - dur_time;
        start_time = event[0];
    }
}