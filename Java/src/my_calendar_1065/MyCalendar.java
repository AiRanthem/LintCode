package src.my_calendar_1065;

import java.util.Map;
import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            if(cnt > 1){
                map.put(start, map.get(start)-1);
                map.put(end,map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}
