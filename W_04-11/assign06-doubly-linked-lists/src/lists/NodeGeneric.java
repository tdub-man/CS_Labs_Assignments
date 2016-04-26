package lists;

/**
 * Created by tanner on 4/21/16.
 */
public class NodeGeneric<T> {
    private Node previous, next;
    private T data;

    public NodeGeneric() {

    }

    public NodeGeneric(T data) {
        this.data = data;
    }

    public NodeGeneric(T data, Node previous, Node next) {
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
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
