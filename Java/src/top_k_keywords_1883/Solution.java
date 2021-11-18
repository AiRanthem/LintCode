package src.top_k_keywords_1883;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Solution {
    Map<String, int[]> nextMap;

    /**
     * 给定一个评论列表reviews，一个关键字列表 keywords 以及一个整数k。
     * 找出在不同评论中出现次数最多的前k个关键词，这k个关键词按照出现次数的由多到少来排序。
     * 字符串不区分大小写，如果关键字在不同评论中出现的次数相等，请按字母顺序从小到大排序。
     * <p>
     * 如果K大于列表keywords的长度，则直接输出keywords
     * keywords 的列表长度范围是: [1, 100]
     * reviews 的列表长度范围是: [1: 1000]
     * kewords[i] 由小写字母组成
     * reviews[i] 由大小写字母以及标点符号: [ "[", "\", "!", "?", ",", ";" , ".", "]", " "] 组成
     *
     * @param K:        a integer
     * @param keywords: a list of string
     * @param reviews:  a list of string
     * @return return the top k keywords list
     */
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        // init
        nextMap = new HashMap<>(keywords.length);
        for (String keyword : keywords) {
            nextMap.put(keyword, cacuKmpNext(keyword));
        }
        K = Math.min(K, keywords.length);
        HashMap<String, Integer> counter = new HashMap<>();

        // count
        for (String keyword : keywords) {
            counter.put(keyword, 0);
        }
        for (String review : reviews) {
            for (String keyword : keywords) {
                counter.put(keyword, counter.get(keyword) + count(keyword, review.toLowerCase(Locale.ROOT)));
            }
        }

        // output
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(counter.entrySet());
        entries.sort((o1, o2) -> {
            Integer v1 = o1.getValue();
            Integer v2 = o2.getValue();
            if (v1.equals(v2)) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return v2 - v1;
        }); // descrease
        ArrayList<String> res = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            res.add(entries.get(i).getKey());
        }
        return res;
    }

    public int count(String keyword, String string) {
        int[] next = nextMap.get(keyword);
        int x = 0, y = 0;
        while (x < string.length()) {
            if (string.charAt(x) == keyword.charAt(y)) {
                x++;
                y++;
            } else if (y != 0) {
                y = next[y - 1];
            } else {
                x++;
            }
            if (y == keyword.length()) { // found
                int begin = x - keyword.length() - 1;
                boolean ok =
                        (x == string.length() || string.charAt(x) > 'z' || string.charAt(x) < 'a') && // end of a word
                                (begin == -1 || string.charAt(begin) > 'z' || string.charAt(begin) < 'a'); // begin of a word
                if (ok) {
                    return 1;
                } else {
                    y = 0; // reset y to find again
                }
            }
        }
        return 0;
    }

    /**
     * KMP 构建 next 数组。
     * P 的 next 数组定义为：next[i] 表示 P[0:i] 这一个子串，使得 前k个字符恰等于后k个字符 的最大的k.
     * next数组的作用是，当KMP进行匹配时，在P[i]时发现不同，则模式串指针i回滚至next[i]，即前后缀相等的**下一个**
     * <p>
     * 已知 next[x-1] = k 的情况下，令t = next[x-1]，x++
     * 如果 P[x] == P[t]，那么next[x] = t+1
     * 否则，对前序字串P[0:t]求自前后公共前后缀，结论是 t = next[t-1]，继续迭代
     * KMP全部思路见 https://www.zhihu.com/question/21923021/answer/1032665486
     * 下方是使用双指针的一个DP实现
     *
     * @param p a string
     * @return the next array
     */
    public int[] cacuKmpNext(String p) {
        int[] next = new int[p.length()];
        next[0] = 0;
        int x = 1, y = 0; // x is fast, y is slow
        while (x < next.length) {
            if (p.charAt(x) == p.charAt(y)) {
                y++; // 根据所谓的“下一个匹配点”属性和最大长度定义，都需要先+1
                next[x] = y;
                x++;
            } else if (y != 0) { // 可以回溯进行匹配
                y = next[y - 1];
            } else { // y = 0 表示 p[0] != p[x] 且经过几次迭代没有任何前后缀满足条件，保留0.
                x++;
            }
        }
        return next;
    }
}