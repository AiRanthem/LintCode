package src.reverse_linked_list_35;

import src.utils.ListNode;

public class Solution {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode before, cur, next;
        before = head;
        cur = head.next;
        before.next = null;
        while (cur != null){
            next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
        }
        return before;
    }
}