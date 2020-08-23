package src.reverse_linked_list_ii_36;

import utils.ListNode;

public class Solution {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode before = first, cur = head, next = null;
        ListNode breakpoint;
        // find start point
        for (int i = 0; i < m - 1; i++) {
            before = cur;
            cur = cur.next;
        }
        // remember
        breakpoint = before;
        // reverse
        for (int i = m; i <= n; i++) {
            next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
        }
        breakpoint.next.next = next;
        breakpoint.next = before;
        return first.next;
    }
}
