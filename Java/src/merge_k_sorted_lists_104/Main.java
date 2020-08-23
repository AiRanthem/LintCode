package src.merge_k_sorted_lists_104;

import utils.ListBuilder;
import utils.ListNode;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {2, 6};
        int[] b = {5};
        int [] c = {7};
        ListBuilder listBuilder = new ListBuilder();
        ListNode la = listBuilder.build(a, true);
        ListNode lb = listBuilder.build(b, true);
        ListNode lc = listBuilder.build(c, true);
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(la);
        listNodes.add(lb);
        listNodes.add(lc);
        ListNode head = solution.mergeKLists(listNodes);
        System.out.println();
    }
}
