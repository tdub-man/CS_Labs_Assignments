package cs1302.linkedList;

/**
 * Created by tanner on 4/21/16.
 */
public class NodeGeneric<T> {
    private T data;
    private NodeGeneric<T> link;

    public NodeGeneric(T initData, NodeGeneric<T> initLink) {
        data = initData;
        link = initLink;
    }

    public NodeGeneric(T initData) {
        data = initData;
    }

    public NodeGeneric() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeGeneric<T> getLink() {
        return link;
    }

    public void setLink(NodeGeneric<T> link) {
        this.link = link;
    }
}
