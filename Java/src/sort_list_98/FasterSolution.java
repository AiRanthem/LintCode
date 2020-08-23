package src.sort_list_98;

import utils.RandomListNode;

import java.util.HashMap;

public class FasterSolution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // maps a node to its copy
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode base = new RandomListNode(0), bp = base, temp;
        while (head != null) {
            if (map.containsKey(head)) temp = map.get(head);
            else {
                temp = new RandomListNode(head.label);
                map.put(head, temp);
            }
            bp.next = temp;
            if (head.random == null) temp = null;
            else if (map.containsKey(head.random)) temp = map.get(head.random);
            else {
                temp = new RandomListNode(head.random.label);
                map.put(head.random, temp);
            }
            bp.next.random = temp;
            head = head.next;
            bp = bp.next;
        }
        return base.next;
    }
}
