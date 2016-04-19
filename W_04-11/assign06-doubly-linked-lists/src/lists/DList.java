package lists;


/**
 * Created by Ben on 4/12/2016.
 */
public class DList {

    private Node base;

    public DList() {
        base = new Node();
        base.setNext(base);
        base.setPrevious(base);
    }

    /**
     * Return the number of elements in the list.
     */
    public int size() {
        int count = 0;
        Node n = base.getNext();
        while(n != base) {
            ++count;
            n = n.getNext();
        }

        return count;
    }

    /**
     * Return the element at index i.
     * If i is out of bounds (less than 0 or greater than or
     *  equal to size()) throw an IndexOutOfBounds exception.
     */
    public Object get(int i) {
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node n = base.getNext();
            while(i > 0) {
                n = n.getNext();
                --i;
            }
            return n.getData();
        }
    }

    /**
     * Change the value at index i to 'value'.
     * Return the old value stored at index i.
     * If i is out of bounds (less than 0 or greater than or
     *  equal to size()) throw an IndexOutOfBounds exception.
     *
     */
    public Object set(int i, Object value) {
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node n = base.getNext();
            while(i > 0) {
                n = n.getNext();
                --i;
            }
            Object old = n.getData();
            n.setData(value);

            return old;
        }
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
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node newElem = new Node(element);
            Node n = base.getNext();
            while(index > 0) {
                n = n.getNext();
                --index;
            }

            n.getPrevious().setNext(newElem);
            newElem.setPrevious(n.getPrevious());
            n.setPrevious(newElem);
            newElem.setNext(n);
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
            throw new IndexOutOfBoundsException();
        }
        else {
            Node n = base.getNext();
            while(index > 0) {
                n = n.getNext();
                --index;
            }
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());

            return n.getData();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            // if obj is null, then it cannot be equal since 'this' is not null
            return false;
        else if(!(obj instanceof DList))
            // if obj is not a DList, then it cannot be equal to 'this'
            return false;
        else {
            // cast since we know obj is a DList
            DList dl = (DList)obj;
            // prepare to compare nodes
            Node p = this.base;
            Node q = dl.base;
            // stop if either list is exhausted
            while(p != this.base && q != dl.base) {
                // compare the data
                if(!p.getData().equals(q.getData()))
                    // if data in current node not equal, the lists are not equal
                    // return false;
                    return false;
                else {
                    // data in current nodes is equal, so keep looking
                    p = p.getNext();
                    q = q.getNext();
                }
            }
            // All nodes checked are equal, otherwise we would have returned false already
            // Now just make sure both lists have been completely examined
            return p == this.base && q == dl.base;
        }
    }

    public boolean hasProperStructure() {
        Node p = base;
        do {
            if(p.getNext().getPrevious() != p || p.getPrevious().getNext() != p)
                return false;
            p = p.getNext();
        } while(p != base);
        return true;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = base.getNext();
        while(p != base) {
            sb.append(p.getData());
            if(p.getNext() != base)
                sb.append(",");
            p = p.getNext(); // Line forgotten in original code
        }
        sb.append("]");
        return sb.toString();
    }
}
