package src.exclusive_time_1116;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    /**
     * 给定一个不可中断单线程CPU的n个函数的运行日志，返回这些函数的执行时间片。
     * 每个函数都有一个唯一的id，从0到n-1。一个函数可能会被递归调用或者被其他函数调用。
     * 日志是一串字符串，其格式为：function_id:start_or_end:timestamp。例如：0:start:0意味着函数0从时间片0开始时执行。0:end:0意味着函数0从时间片0末尾结束。
     * 函数的“独占时间”是指这个函数所花费的时间片，调用其他函数所花费的时间片不会被算入该函数的独占时间。按照函数id升序返回每一个函数的独占时间。
     * <p>
     * 思路：使用一个栈来模拟调用堆栈，记录当前的函数ID。使用一个Map来记录函数的已运行时间。
     * 当开始一个新的函数时，如果已经有运行的函数（递归调用），那么先记录当前函数的已运行时间。接着，当前函数入栈。
     * 当一个函数结束时，首先给当前函数已运行时间进行记录（由于结束表示时间片尾，需要+1）,然后堆栈pop（堆栈顶一定是结束的这个函数）
     *
     * @param n:    a integer
     * @param logs: a list of log strings
     * @return return a list of integers
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        TreeMap<Integer, Integer> duration = new TreeMap<>();
        Stack<Integer> stack = new Stack<>();
        int lastTimestamp = 0; // last function starts at the beginning of that timestamp

        for (String logStr : logs) {
            String[] log = logStr.split(":");
            int curFid = Integer.parseInt(log[0]);
            String action = log[1];
            int curTimestamp = Integer.parseInt(log[2]);
            Integer lastFid = stack.size() == 0 ? null : stack.peek();

            if (action.equals("start")) {
                if (lastFid != null) {
                    duration.put(lastFid, duration.get(lastFid) + curTimestamp - lastTimestamp);
                }
                if (!duration.containsKey(curFid)) {
                    duration.put(curFid, 0);
                }
                duration.putIfAbsent(curFid, 0); // a function can be called more than once.
                stack.push(curFid);
                lastTimestamp = curTimestamp;
            } else { // "end"
                duration.put(curFid, duration.get(curFid) + curTimestamp - lastTimestamp + 1);
                stack.pop();
                lastTimestamp = curTimestamp + 1; // next function starts at the beginning of next timestamp
            }
        }

        int[] res = new int[n];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : duration.entrySet()) {
            res[i++] = entry.getValue();
        }
        return res;
    }
}