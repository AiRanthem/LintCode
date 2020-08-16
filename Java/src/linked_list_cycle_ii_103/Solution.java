package src.linked_list_cycle_ii_103;

import src.utils.ListNode;

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}