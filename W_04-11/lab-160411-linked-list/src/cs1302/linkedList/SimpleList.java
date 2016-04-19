package cs1302.linkedList;

import java.util.Iterator;

/**
 * Created by tanner on 4/19/16.
 */
public class SimpleList implements Iterable<Node> {
    private class NodeIter implements Iterator {
        private Node current;

        public NodeIter(){
            reset();
        }

        public Node peek() {
            return current;
        }
        public Node next() {
            if(!hasNext()) {
                throw new NullPointerException("No next element");
            }
            else {
                Node ret = current;
                current = current.getLink();
                return ret;
            }
        }
        public boolean hasNext() {
            return (current != null);
        }
        public void point(Node n) {
            current = n;
        }
        public void reset() {
            current = head;
        }
    }

    private Node head;
    private NodeIter iter;

    public SimpleList(){
        iter = new NodeIter();
    }
    public SimpleList(Object[] items) {
        iter = new NodeIter();
        for(int i=0; i<items.length; ++i) {
            this.add(i,items[i]);
        }
    }
    public Iterator iterator() {
        return new NodeIter();
    }

    public int size() {
        iter.reset();
        if(head == null) {
            return 0;
        }
        else {
            int count = 0;
            do {
                ++count;
                iter.next().getData();
            } while(iter.hasNext());

            iter.reset();
            return count;
        }

//        return Toolkit.size(head);
    }
    public Object get(int i) {
        return Toolkit.locate(head, i).getData();
    }
    public Object set(int i, Object value) {
        Node n = Toolkit.locate(head,i);
        Object rtval = n.getData();
        n.setData(value);
        return rtval;
    }
    public void add(int index, Object element) {
        if(head == null || index == 0) {
            head = Toolkit.headInsert(head, element);
            iter.reset();
        }
        else {
            Node p = Toolkit.locate(head, index-1);
            Toolkit.insert(p, element);
        }
    }
    public void append(Object element) {
        add(size(),element);
    }
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("remove index out of bounds: " + index);
        } else if (index == 0) {
            Object rtval = head.getData();
            head = Toolkit.headRemove(head);
            iter.reset();
            return rtval;
        } else {
            Node n = Toolkit.locate(head, index - 1);
            Object rtval = n.getLink().getData();
            Toolkit.remove(n);
            return rtval;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        while(p != null) {
            sb.append(p.getData());
            if(p.getLink() != null)
                sb.append(",");
            p = p.getLink();
        }
        sb.append("]");
        return sb.toString();
    }

    public Object[] toArray() {
        Object[] arr = new Object[size()];
        int index = 0;
        while(iter.hasNext()) {
            arr[index] = iter.next().getData();
            ++index;
        }

        return arr;
    }

}
