package cs1302.linkedList;

import javax.tools.Tool;
import java.util.Objects;

/**
 * Created by Ben on 10/8/2015.
 */
public class SimpleList {
    private Node head;
//    private Node tail;

    public SimpleList() {
    }

    /**
     * Return the element at index i.
     * If i is out of bounds (less than 0 or greater than or
     *  equal to size()) throw an IndexOutOfBounds exception.
     */
    public Object get(int i) {
        return Toolkit.locate(head, i).getData();
    }

    /**
     * Return the number of elements in the list.
     */
    public int size() {
        return Toolkit.size(head);
    }



    /**
     * Change the value at index i to 'value'.
     * Return the old value stored at index i.
     * If i is out of bounds (less than 0 or greater than or
     *  equal to size()) throw an IndexOutOfBounds exception.
     *
     */
    public Object set(int i, Object value) {
        Node n = Toolkit.locate(head,i);
        Object rtval = n.getData();
        n.setData(value);
        return rtval;
    }


    /**
     * Insert the new element so that it ends up as index 'index'.
     * If i is out of bounds (less than 0 or greater than
     *  size()) throw an IndexOutOfBounds exception.
     *
     * Note that index is allowed to be equal to size().  This just
     * means the new element will go at the end of the list.
     */
    public void add(int index, Object element) {
        if(head == null) {
            head = Toolkit.headInsert(head, element);
//            tail = head;
        } else if(index == 0) {
            head = Toolkit.headInsert(head, element);
//        } else if(index == size()) {
//            Toolkit.insert(tail, element);
        } else {
            Node p = Toolkit.locate(head, index-1);
            Toolkit.insert(p, element);
        }
    }

    /**
     * Remove the element at index i and return the element value.
     *
     * If i is out of bounds (less than 0 or greater than or
     *  equal to size()) throw an IndexOutOfBounds exception.
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("remove index out of bounds: " + index);
        } else if(index == 0) {
            Object rtval = head.getData();
            head = Toolkit.headRemove(head);
//            if(head == null || head.getLink()==null)
//                tail = head;
            return rtval;
        } else {
            Node n = Toolkit.locate(head, index-1);
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
        }
        sb.append("]");
        return sb.toString();
    }



}
