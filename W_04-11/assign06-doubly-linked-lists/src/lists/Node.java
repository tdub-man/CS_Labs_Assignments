package lists;

/**
 * Created by Ben on 4/14/2016.
 */
public class Node {
    private Node previous, next;
    private Object data;

    public Node() {

    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node previous, Node next) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
