package cs1302.inClass;

/**
 * Created by bsetzer on 4/11/2016.
 */
public class Node {
    private Object datum;
    private Node  next;  // reference to a Node object

    public Node(Object datum, Node next) {
        this.datum = datum;
        this.next = next;
    }

    public Node(Object datum) {
        this.datum = datum;
        // what is next?????  null is the default
        // this.next = null;
    }

    public Object getDatum() {
        return datum;
    }

    public void setDatum(Object datum) {
        this.datum = datum;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
