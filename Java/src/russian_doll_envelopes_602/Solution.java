package src.russian_doll_envelopes_602;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    /**
     * 将所有信封按照width增序、height减序排序
     * 则就是求height的最大上升子序列（LIS）长度
     *
     * @param envelopes: a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) return 1;
                if(o1[0] < o2[0]) return -1;
                return -Integer.compare(o1[1], o2[1]);
            }
        });

        TreeSet<Integer> set = new TreeSet<>();
        for (int[] envelope : envelopes) {
            Integer ceiling = set.ceiling(envelope[1]);
            if(ceiling != null){
                set.remove(ceiling);
            }
            set.add(envelope[1]);
        }
        return set.size();
    }
}
