package cs1302.inClass;

import cs1302.inClass.*;

/**
 * Created by bsetzer on 4/13/2016.
 */
public class Toolkit {

    public static int size(Node head) {
        int count = 0;
        Node p = head;
        while(p != null) {
            count++;  // count the node
            p = p.getNext();  // go to the next node
        }
//        for(Node p = head; p != null; p = p.getNext()) {
//            count++;
//        }
        return count;
    }

    /**
     *  Insert a new node at the beginning of the list pointed to by head.
     *  Return the new beginning of the list, the new node.
     *  The new node will contain the data 'entry'.
     */
    public  static  Node headInsert(Node head, Object entry) {
        Node newHead = new Node(entry);
        newHead.setNext(head);
//        head = newHead;
        return  newHead;
    }

    /**
     * Insert a new node after the node pointed to by previous.
     * Return the new node.
     * The new node will contain the data 'entry'
     * @param previous  Should not be null
     */
    public static  Node insert(Node previous, Object entry) {
        Node newNode = new Node(entry);
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
        return newNode;
    }
}

















