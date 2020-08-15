package src.linked_list_cycle_102;

import src.utils.ListNode;

public class Solution {
    /**
     * 标准解法快慢指针
     * 如果有环，假设某一步上，快指针越过了慢指针，由于快指针只走两步，所以现在最多快指针在慢指针前一步
     * 慢在x，快在x+1
     * 倒退一个时间点，则发现都在x-1，证明如果有环，快指针一定会遇到慢指针。
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}


class MySolution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        ListNode cur, next;
        cur = head;
        while (cur!=null){
            if (cur.next == cur) return true;
            next = cur.next;
            cur.next = cur;
            cur = next;
        }
        return false;
    }
}
