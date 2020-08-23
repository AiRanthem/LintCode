package src.merge_k_sorted_lists_104;

import utils.ListNode;

import java.util.List;

/**
 * 归并排序
 */
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        int size = lists.size();
        if (size == 1) {
            return lists.get(0);
        } else {
            ListNode left = mergeKLists(lists.subList(0, size / 2));
            ListNode right = mergeKLists(lists.subList(size / 2, size));
            return mergeTwoLists(left, right);
        }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        cur.next = a != null ? a : b;
        return head.next;
    }
}

