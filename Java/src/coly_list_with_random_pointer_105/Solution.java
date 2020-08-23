package src.coly_list_with_random_pointer_105;

import utils.RandomListNode;

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // step1
        // 按照next的顺序复制节点，调整老链表的next顺序，使得老节点的next指向其拷贝，
        // 拷贝的next和random是老节点原来的next、random。
        RandomListNode cursor = head;
        RandomListNode copy;
        while (cursor != null) {
            copy = new RandomListNode(cursor.label);
            copy.next = cursor.next;
            copy.random = cursor.random;
            cursor.next = copy;
            cursor = copy.next;
        }
        // step2
        // 现在所有老节点的next都是它的拷贝；
        // 拷贝的random指向老节点的random
        // 所以对于拷贝的next指针，移动成next就能调整到random的拷贝上去。
        cursor = head;
        while (cursor != null) {
            copy = cursor.next;
            if (copy.random != null)
                copy.random = copy.random.next;
            cursor = copy.next;
        }
        // step3
        // 将两个耦合的链表调整next指针解耦即可
        cursor = head;
        RandomListNode deep_copy = head.next;
        while (cursor != null) {
            copy = cursor.next;
            cursor.next = copy.next;
            cursor = copy.next;
            if (cursor != null)
                copy.next = cursor.next;
        }
        return deep_copy;
    }
}