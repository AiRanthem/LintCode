package src.lfu_cache_24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache {
    int capacity, minFreq;
    Map<Integer, Integer> k2v, k2f;
    Map<Integer, List<Integer>> f2ks;

    /**
     * 用三个map来保存信息：
     * k2v  : key -> value 记录key对应的值
     * k2f  : key -> frequency 记录key被访问的次数
     * f2ks : frequency -> array of key 记录次数和对应的key
     * MAP映射关系：value <- key <-> freq
     *
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        k2v = new HashMap<>(capacity);
        k2f = new HashMap<>();
        f2ks = new HashMap<>();
        minFreq = 0;
        f2ks.put(0, new ArrayList<>());
    }

    /**
     * 如果是更新操作的话要调用一次get
     * 如果插入操作且overflow了，那么需要根据minFreq查f2ks
     * 由于f2ks是按照放入顺序排列的，所以第0个一定是最早放入的，取出删掉就行
     * 对于f2ks，取出removeKey，remove，之后把新的key放入minFreq的队列
     * 对于k2v，remove removeKey即可
     * 对于k2c，remove removeKey，并且put新的key为1
     * minFreq设置成0
     * 最后对k2v进行put就行
     *
     * @param key:   An integer
     * @param value: An integer
     */
    public void set(int key, int value) {
        // 更新
        if (k2v.get(key) != null) {
            get(key);
            k2v.put(key, value);
            return;
        }
        // 插入
        if (k2v.size() >= capacity) {
            // 移除LFU
            Integer removeKey = f2ks.get(minFreq).get(0);
            f2ks.get(minFreq).remove(0);
            k2v.remove(removeKey);
            k2f.remove(removeKey);
        }
        minFreq = 0;
        k2v.put(key, value);
        k2f.put(key, 0);
        f2ks.get(0).add(key);
    }

    /**
     * get的时候从 k2v 获取数据，不会对它进行任何修改。
     * 对于k2f，值需要+1
     * 对于f2ks，需要把key移动到freq+1的队列中。
     *
     * @param key: An integer
     * @return An integer
     */
    public int get(int key) {
        if (!k2v.containsKey(key)) return -1;
        // get freq
        int freq = k2f.get(key);
        // 从原队列中移除 如果是直接传int的key，看作是index而不是value。
        f2ks.get(freq).remove(Integer.valueOf(key));
        // 有可能最小频率队列被搬空，最小频率要+1
        if (freq == minFreq && f2ks.get(freq).isEmpty()) {
            minFreq++;
        }
        // 放在这里更新k2f可以少做一次+运算
        k2f.put(key, ++freq);
        // 还没有这个freq队列，证明是新的最高频率，要生成一个新的队列
        f2ks.computeIfAbsent(freq, k -> new ArrayList<>());
        // 移动到新队列
        f2ks.get(freq).add(key);
        return k2v.get(key);
    }
}
