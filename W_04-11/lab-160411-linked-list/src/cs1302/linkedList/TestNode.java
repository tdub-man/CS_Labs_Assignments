package cs1302.linkedList;

/**
 * Created by tanner on 4/12/16.
 */
public class TestNode {

    public static void main(String[] args) {
        int size = 5;
        Node head = new Node(-56.2,
                    new Node(45.9,
                    new Node(-35.8,
                    new Node(14.7,
                    new Node(23.5)))));

        System.out.println("Third Element:   " + getElement(head,2));

        System.out.print("Printed List:    ");
        printList(head,size);

        double sum = 0;
        for (int i=0; i<size; ++i) {
            sum += (double) getElement(head,i);
//            System.out.println("Count: " + i);
        }
        System.out.println("Average:         " + sum/size);

        for(int i=0; i<size; ++i) {
            Node n = getNode(head,i);
            n.setData((double) n.getData() + 1);
        }
        System.out.print("Elements + 1:    ");
        printList(head,size);

        Node nHead = removeNode(head,1);
        System.out.print("W/o 2nd element: ");
        printList(nHead,findListSize(nHead));
    }

    public static Object getElement(Node head, int elem) {
        if(elem == 0) {
            return head.getData();
        }
        else {
            return getElement(head.getLink(),elem-1);
        }
    }
    public static Node getNode(Node head, int elem) {
        if(elem == 0) {
            return head;
        }
        else {
            return getNode(head.getLink(),elem-1);
        }
    }
    public static Node removeNode(Node head, int elem) {
        head = cloneList(head,findListSize(head));

        if(elem == 0) {
            return head.getLink();
        }
        else {
            Node prev = getNode(head, elem-1);
            Node next = getNode(head, elem+1);
            prev.setLink(next);

            return head;
        }
    }
    public static void printList(Node head, int length) {
        for (int i=0; i<length; ++i) {
            System.out.print(getElement(head,i) + " ");
        }
        System.out.println();
    }
    public static Node cloneList(Node head, int length) {
        if(length == 0) {
            if(head == null) {
                return null;
            }
            else {
                return new Node(head.getData());
            }
        }
        else {
            return new Node(head.getData(),cloneList(head.getLink(),length-1));
        }
    }
    public static int findListSize(Node head) {
        if (head.getLink() == null) {
            return 1;
        }
        else {
            return findListSize(head.getLink()) + 1;
        }
    }
}
