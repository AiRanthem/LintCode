package utils;

public class ListBuilder {
    public ListNode build(int[] vals, boolean headless) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return headless ? head.next : head;
    }
}
