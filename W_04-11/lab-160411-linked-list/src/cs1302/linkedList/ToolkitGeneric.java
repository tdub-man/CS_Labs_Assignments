package cs1302.linkedList;

/**
 * Created by tanner on 4/21/16.
 */
public class ToolkitGeneric {
    public static <E> int size(NodeGeneric<E> head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.getLink();
        }
        return count;
    }


    /**
     *  Insert a new node at the beginning of the list pointed to by head.
     *  Return the new beginning of the list, the new node.
     *  The new node will contain the data 'entry'.
     */
    public static <E> NodeGeneric<E> headInsert(NodeGeneric<E> head, E entry){
        return new NodeGeneric<E>(entry, head);
    }

    /**
     * Insert a new node after the node pointed to by previous.
     * Return the new node.
     * The new node will contain the data 'entry'
     * @param previous  Should not be null
     */
    public static <E> NodeGeneric<E> insert(NodeGeneric<E> previous, E entry) {
        NodeGeneric<E> newNode = new NodeGeneric<E>(entry, previous.getLink());
        previous.setLink(newNode);
        return newNode;
    }
    /**
     * Remove the head node of the list starting at head.
     * Return the head of the new list.
     *
     * @param head  Should not be null
     *
     */
    public static <E> NodeGeneric<E> headRemove(NodeGeneric<E> head) {
        return head.getLink();
    }

    /**
     * Remove the node following node previous.
     * Returns the new node next after previous.
     *
     * @param previous  Should not be null.  Also, the next node after should
     *                  not be null.
     */

    public static <E> NodeGeneric<E> remove(NodeGeneric<E> previous) {
        NodeGeneric<E> nextNode = previous.getLink();
        NodeGeneric<E> theNext  = nextNode.getLink();
        previous.setLink(theNext);
        //previous.setLink(previous.getLink().getLink());
        return theNext;
    }
    /**
     * Search for target in the list pointed to by head and return the first node found.
     * Return null if no node is found.
     */
    public static <E> Node search(Node head, E target) {
        Node cursor = head;
        while(cursor != null && !cursor.getData().equals(target)) {
            cursor = cursor.getLink();
        }
        return cursor;
    }

    /**
     *   Return the node at index 'n' in the list starting at head.
     *   If n is out of bounds, throw an index out of bounds exception.
     */
    public static <E> NodeGeneric<E> locate(NodeGeneric<E> head, int n) {
        if(n < 0) {
            throw new IndexOutOfBoundsException("Node list locate index out of bounds: " + n);
        }
        else {
            int counter = 0;
            NodeGeneric<E> cursor = head;
            while(cursor != null && counter < n) {
                cursor = cursor.getLink();
                counter++;
            }
            if(cursor == null)
                throw new IndexOutOfBoundsException("Node list locate index out of bounds: " + n);
            else
                return cursor;
        }
    }



    /**
     * Create a copy of the list start at head and return the starting node of the copy.
     */
    public static <E> NodeGeneric<E> copy(NodeGeneric<E> head) {
        if(head == null)
            return null;
        else {
            NodeGeneric<E> h = headInsert(null, head.getData());
            NodeGeneric<E> t = h;
            NodeGeneric<E> cursor = head.getLink();
            while (cursor != null) {
                t = insert(t, cursor.getData());
                cursor = cursor.getLink();
            }
            return h;
        }
    }

}
