package cs1302.linkedList;

/**
 * Created by tanner on 4/12/16.
 */
public class TestNode {
    private static Node head = new Node(-56.2,
                               new Node(45.9,
                               new Node(-35.8,
                               new Node(14.7,
                               new Node(23.5)))));
    private static int size = 5;


    public static void main(String[] args) {
        System.out.println(getElement(head,2));

        printList(head);

        double sum = 0;
        for (int i=0; i<size; ++i) {
            sum += (double) getElement(head,i);
            System.out.println("Count: " + i);
        }
        System.out.println("Average: " + sum/size);

        for(int i=0; i<size; ++i) {
            Node n = getNode(head,i);
            n.setData((double) n.getData() + 1);
        }
        printList(head);

        removeNode(1); // Change removeNode to return a Node
        printList(head);
    }

    private static Object getElement(Node head, int elem) {
        if(elem == 0) {
            return head.getData();
        }
        else {
            return getElement(head.getLink(),elem-1);
        }
    }
    private static Node getNode(int elem) {
        if(elem == 0) {
            return head;
        }
        else {
            return getNode(head.getLink(),elem-1);
        }
    }
    private static Node getNode(Node head, int elem) {
        if(elem == 0) {
            return head;
        }
        else {
            return getNode(head.getLink(),elem-1);
        }
    }
    private static void removeNode(int elem) {
        if(elem == 0) {
            head = head.getLink();
        }
        else {
            Node prev = getNode(head,elem-1);
            Node next = getNode(head,elem+1);
            prev.setLink(next);
        }
        size -= 1;
    }

    private static void printList(Node head) {
        for (int i=0; i<size; ++i) {
            System.out.print(getElement(head,i) + " ");
        }
        System.out.println();
    }
}
