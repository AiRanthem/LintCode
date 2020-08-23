package tencent;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // num of nodes
        int k = scanner.nextInt(); // kth node to delete
        int next_val = scanner.nextInt();
        if (k != 1) {
            System.out.print(next_val);
        }
        for (int i = 1; i < n; i++) {
            next_val = scanner.nextInt();
            if (i == k-1) continue;
            System.out.print(' ');
            System.out.print(next_val);
        }
    }
}
