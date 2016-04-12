package cs1302.linkedList;

/**
 * Based on examples in Main and Savitch, Data Structures & Other Objects Using C++, Fourth Edition.
 *
 * Created by Ben on 10/8/2015.
 */
public class Node {
    private Object data;
    private Node link;

    public Node(Object initData, Node initLink) {
        data = initData;
        link = initLink;
    }

    public Node(Object initData) {
        data = initData;
    }

    public Node() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }


}

