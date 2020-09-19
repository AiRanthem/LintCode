package src.permutations_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<List<Integer>> ans;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        this.nums = nums;
        if (nums.length == 0){
            ans = new ArrayList<>(0);
            List<Integer> temp = new ArrayList<>(0);
            ans.add(temp);
            return ans;
        }
//        return non_recursion_strategy();
        recursion_strategy(0, new ArrayList<>(nums.length));
        return ans;
    }
    /**
     * 非迭代方法
     * 两种操作——
     * 1. 替换 此时排列已经满了，那最后一位移除，替换为出现在它之后的下一个元素。如果不存在下一个元素，则递归替换上一个元素
     * 2. 放置 此时排列没有满，已经完成了一部分排列。将还没有排列的元素按照出现顺序依次放入排列中填满整个排列
     * 用栈来保存排列的下标，在初始时，栈中放入一个-1
     * 每次采用先替换再放置的操作
     * @return: A list of permutations.
     */
    public List<List<Integer>> non_recursion_strategy() {
        Stack<Integer> stack = new Stack<>(); // 存的是下标
        stack.push(-1); // 初始状态
        boolean[] inStack = new boolean[nums.length];
        while (!stack.empty()){
            // 替换，移除最后一位
            Integer pop = stack.pop();
            if (pop != -1) inStack[pop] = false;
            // 寻找下一个元素
            int next = -1;
            for (int i = pop + 1; i < nums.length; i++) {
                if (!inStack[i]){
                    next = i;
                    break;
                }
            }
            // 不存在下一个元素，递归替换
            if (next == -1){
                continue;
            }
            // 更新最后一位
            stack.push(next);
            inStack[next] = true;
            // 放置,填充满排列
            for (int i = 0; i < nums.length; i++) {
                if (!inStack[i]){
                    stack.push(i);
                    inStack[i] = true;
                }
            }
            // 根据stack中保存的下标排列,生成实际的值排列
            List<Integer> temp = new ArrayList<>(nums.length);
            for (Integer integer : stack) {
                temp.add(nums[integer]);
            }
            ans.add(temp);
        }
        return ans;
    }

    /**
     * 迭代方法,经典的交换策略
     */
    public void recursion_strategy(int start, List<Integer> cur) {
        if (start == nums.length){
            ArrayList<Integer> temp = new ArrayList<>(cur);
            ans.add(temp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(start, i);
            cur.add(nums[start]);
            recursion_strategy(start + 1, cur);
            cur.remove(cur.size()-1);
            swap(start, i);
        }
    }

    public void swap(int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
