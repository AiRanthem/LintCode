package src.partition_list_96;

import utils.ListNode;

public class Solution {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode sp = small; // small pointer
        ListNode bp = big; // big pointer
        ListNode next;
        while (head != null){
            next = head.next;
            if (head.val < x) {
                sp.next = head;
                sp = head;
                sp.next = null;
            } else {
                bp.next = head;
                bp = head;
                bp.next = null;
            }
            head = next;
        }
        sp.next = big.next;
        return small.next;
    }
}