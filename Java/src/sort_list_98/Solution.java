package src.sort_list_98;

import utils.ListNode;

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    ListNode bp;
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        ListNode base = new ListNode(0);
        bp = base;
        while (left != null && right != null){
            if (left.val < right.val){
                left = operateMerge(left);
            } else {
                right = operateMerge(right);
            }
        }
        while (left != null) left = operateMerge(left);
        while (right != null) right = operateMerge(right);
        return base.next;
    }

    public ListNode operateMerge(ListNode node){
        bp.next = node;
        node = node.next;
        bp = bp.next;
        bp.next = null;
        return node;
    }
}
