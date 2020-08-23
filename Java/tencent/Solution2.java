package tencent;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next(); // num of nodes
        int k = scanner.nextInt(); // kth node to delete
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++){
                String substring = s.substring(i, j + 1);
                if (set.contains(substring)) continue;
                if (set.size() < k) {
                    set.add(substring);
                } else {
                    if (set.ceiling(substring) != null){
                        set.pollLast();
                        set.add(substring);
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(set.last());
    }
}
