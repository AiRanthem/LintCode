package src.plus_one_linked_list_904;

import src.utils.ListNode;

import java.util.Stack;

public class Solution {
    /**
     * @param head: the first Node
     * @return the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        int plus_one = 1;
        while (!stack.empty()){
            ListNode top = stack.pop();
            top.val += plus_one;
            if (top.val==10){
                top.val = 0;
                plus_one = 1;
            } else {
                plus_one = 0;
            }
        }

        if(plus_one == 1){
            ListNode new_head = new ListNode(1);
            new_head.next = head;
            return new_head;
        }
        return head;
    }
}
