package cs1302.linkedList;

import java.util.Objects;

/**
 * Created by Ben on 10/8/2015.
 */
public class Toolkit {

    public static int size(Node head) {
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
    public  static  Node headInsert(Node head, Object entry){
        Node newNode = new Node(entry, head);
        return newNode;
    }

    /**
     * Insert a new node after the node pointed to by previous.
     * Return the new node.
     * The new node will contain the data 'entry'
     * @param previous  Should not be null
     */
    public static  Node insert(Node previous, Object entry) {
        Node newNode = new Node(entry, previous.getLink());
        previous.setLink(newNode);
        return newNode;
    }

    /**
     * Search for target in the list pointed to by head and return the first node found.
     * Return null if no node is found.
     */
    public static  Node search(Node head, Object target) {
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
    public static  Node locate(Node head, int n) {
        if(n < 0) {
            throw new IndexOutOfBoundsException("Node list locate index out of bounds: " + n);
        }
        else {
            int counter = 0;
            Node cursor = head;
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
     * Remove the head node of the list starting at head.
     * Return the head of the new list.
     *
     * @param head  Should not be null
     *
     */
    public static  Node headRemove(Node head) {
        return head.getLink();
    }

    /**
     * Remove the node following node previous.
     * Returns the new node next after previous.
     *
     * @param previous  Should not be null.  Also, the next node after should
     *                  not be null.
     */
    public static  Node remove(Node previous) {
        Node nextNode = previous.getLink();
        Node theNext  = nextNode.getLink();
        previous.setLink(theNext);
        return theNext;
    }

    /**
     * Create a copy of the list start at head and return the starting node of the copy.
     */
    public static  Node copy(Node head) {
        if(head == null)
            return null;
        else {
            Node h = headInsert(null, head.getData());
            Node t = h;
            Node cursor = head.getLink();
            while (cursor != null) {
                t = insert(t, cursor.getData());
                cursor = cursor.getLink();
            }
            return h;
        }
    }

}
