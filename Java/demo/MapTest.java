package demo;

import utils.ListNode;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode listNode = new ListNode(0);
        map.put(0, listNode);
        map.get(0).val = 100;
        System.out.println(listNode.val);
    }
}
