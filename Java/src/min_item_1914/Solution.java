package src.min_item_1914;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 销售主管的任务是出售一系列的物品，其中每个物品都有一个编号。
     * 由于出售具有相同编号的商品会更容易，所以销售主管决定删除一些物品。
     * 现在她知道她最多能删除多少物品，她想知道最终袋子里最少可以包含多少种不同编号的物品。
     *
     * 例如，最开始她有n = 6 个物品，编号为：ids = [1,1,1,2,2,3]，她最多可以删除 m = 2 个物品。
     * 如果删除两个物品 1，则剩下的物品 ids = [1,2,2,3]，此时她拥有三种不同编号的物品。
     * 如果删除两个物品 2，则剩下的物品 ids = [1,1,1,3]，此时她拥有两种不同编号的物品。
     * 如果删除物品 2 和物品 3 各 1个，则剩下的物品 ids = [1,1,1,2]，此时她拥有两种不同编号的物品。
     * 我们发现，物品最多可以剩下两种不同的编号，所以你的程序要返回 2
     *
     * 思路：贪心，先统计每种物品有几个，然后从最少的开始删。
     * @param ids: ID number of items
     * @param m: The largest number of items that can be remove
     * @return the result of the min item
     */
    public int minItem(List<Integer> ids, int m) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (Integer id : ids) {
            counter.put(id, counter.getOrDefault(id, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(counter.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        int rest = entries.size();
        for (Map.Entry<Integer, Integer> entry : entries) {
            m -= entry.getValue();
            if (m < 0) {
                break;
            }
            rest--;
        }
        return rest;
    }
}