package cs1302.linkedList;

import java.util.Iterator;

/**
 * Created by tanner on 4/21/16.
 */
public class SimpleListGeneric<E> implements Iterable<NodeGeneric<E>> {
    private class NodeIter implements Iterator<NodeGeneric<E>> {
        private NodeGeneric<E> current;

        public NodeIter(){
            reset();
        }

        public NodeGeneric<E> peek() {
            return current;
        }
        public NodeGeneric<E> next() {
            if(!hasNext()) {
                throw new NullPointerException("No next element");
            }
            else {
                NodeGeneric<E> ret = current;
                current = current.getLink();
                return ret;
            }
        }
        public boolean hasNext() {
            return (current != null);
        }
        public void point(NodeGeneric<E> n) {
            current = n;
        }
        public void reset() {
            current = head;
        }
    }

    private NodeGeneric<E> head;
    private NodeIter iter;

    public SimpleListGeneric(){
        iter = new NodeIter();
    }
    public SimpleListGeneric(E[] items) {
        iter = new NodeIter();
        for(int i=0; i<items.length; ++i) {
            this.add(i,items[i]);
        }
    }
    public Iterator<NodeGeneric<E>> iterator() {
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
        return ToolkitGeneric.locate(head, i).getData();
    }
    public E set(int i, E value) {
        NodeGeneric<E> n = ToolkitGeneric.locate(head,i);
        E rtval = n.getData();
        n.setData(value);
        return rtval;
    }
    public void add(int index, E element) {
        if(head == null || index == 0) {
            head = ToolkitGeneric.headInsert(head, element);
            iter.reset();
        }
        else {
            NodeGeneric<E> p = ToolkitGeneric.locate(head, index-1);
            ToolkitGeneric.insert(p, element);
        }
    }
    public void append(E element) {
        add(size(),element);
    }
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("remove index out of bounds: " + index);
        } else if (index == 0) {
            Object rtval = head.getData();
            head = ToolkitGeneric.headRemove(head);
            iter.reset();
            return rtval;
        } else {
            NodeGeneric<E> n = ToolkitGeneric.locate(head, index - 1);
            Object rtval = n.getLink().getData();
            ToolkitGeneric.remove(n);
            return rtval;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodeGeneric<E> p = head;
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
        Object[] arr = new Object[size()]; // Cast for generic?
        int index = 0;
        while(iter.hasNext()) {
            arr[index] = iter.next().getData();
            ++index;
        }

        return arr;
    }
}
