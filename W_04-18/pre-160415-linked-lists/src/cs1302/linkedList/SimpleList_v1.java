package cs1302.linkedList;

/**
 * Created by Ben on 10/8/2015.
 */
public class SimpleList_v1 {
    private Node head;
    private Node tail;

    public SimpleList_v1() {
    }

    public void addLast(Object t) {
        if(tail == null) {
            head = new Node(t);
            tail = head;
        } else {
            tail = Toolkit.insert(tail, t);
        }
    }

    public void addFirst(Object t) {
        head = new Node(t, head);
        if(tail == null)
            tail = head;
    }

    public Object removeLast() {
        if(head == null)
            throw  new IllegalStateException("Remove from an empty list");
        else if(head == tail) {
            Object val = head.getData();
            head = tail = null;
            return val;
        } else {
            Node p = head;
            while(p.getLink() != tail)
                p = p.getLink();
            Object val = tail.getData();
            Toolkit.remove(p);
            return val;
        }
    }

    public Object removeFirst() {
        if(head == null)
            throw  new IllegalStateException("Remove from an empty list");
        else if(head == tail) {
            Object val = head.getData();
            head = tail = null;
            return val;
        } else {
            Object val = head.getData();
            head = head.getLink();
            return val;
        }
    }

    public Object get(int i) {
        return Toolkit.locate(head, i).getData();
    }

    public int size() {
        return Toolkit.size(head);
    }
}
