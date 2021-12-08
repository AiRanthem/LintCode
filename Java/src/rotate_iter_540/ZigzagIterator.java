package src.rotate_iter_540;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {

    Iterator<Integer> cursor;
    Iterator<Integer> other;
    Iterator<Integer> tmp;

    /*
     * @param v1: A 1d vector
     * @param v2: A 1d vector
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) {
            cursor = v1.iterator();
            other = v2.iterator();
        } else {
            cursor = v2.iterator();
            other = v1.iterator();
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        Integer next = cursor.next();
        if (other.hasNext()) {
            tmp = other;
            other = cursor;
            cursor = tmp;
        }
        return next;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return cursor.hasNext() || other.hasNext();
    }
}
