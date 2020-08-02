package src.lru_cache_134;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> k2v;
    final LinkNode head;
    LinkNode tail;
    int cap;

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        cap = capacity;
        head = new LinkNode(0);
        tail = head;
        k2v = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!k2v.containsKey(key)) return -1;
        LinkNode cur = head;
        // find cur
        while (cur.key != key) cur = cur.next;
        if (cur != head.next) {
            // pick cur out
            if (cur.next != null)
                cur.next.before = cur.before;
            else tail = cur.before;
            cur.before.next = cur.next;
            // set cur
            cur.next = head.next;
            cur.before = head;
            // pick and set head
            head.next.before = cur;
            head.next = cur;
        }
        return k2v.get(key);
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // update
        if (k2v.containsKey(key)) {
            k2v.put(key, value);
            get(key);
            return;
        }
        // insert
        if (k2v.size() >= cap) {
            // remove LRU if overflow
            k2v.remove(tail.key);
            // rollback tail
            tail = tail.before;
            tail.next = null;
        }
        k2v.put(key, value);
        LinkNode temp = new LinkNode(key);
        if(head.next == null){
            tail = temp;
            tail.before = head;
        } else {
            temp.next = head.next;
            temp.before = head;
            temp.next.before = temp;
        }
        head.next = temp;

    }
}

class LinkNode {
    public int key;
    public LinkNode next;
    public LinkNode before;

    public LinkNode(int key) {
        this.key = key;
    }
}
