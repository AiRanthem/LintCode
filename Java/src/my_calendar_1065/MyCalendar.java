package src.my_calendar_1065;

class MyCalendar {

    Node head;

    public MyCalendar() {
        head = new Node();
    }

    public boolean book(int start, int end) {
        Node cur = head;
        Node before = head;
        while (cur != null && cur.end <= start) {
            before = cur;
            cur = cur.next;
        }
        cur = before;
        if(cur == null) return false;
        if(cur.next==null){
            cur.next = new Node(start, end);
            return true;
        }
        if(cur.next.start >= end){
            Node temp = new Node(start, end);
            temp.next = cur.next;
            cur.next = temp;
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
class Node {
    public int start;
    public int end;
    public Node next;

    Node() {
        start = end = 0;
        next = null;
    }

    Node(int s, int e) {
        start = s;
        end = e;
        next = null;
    }
}
