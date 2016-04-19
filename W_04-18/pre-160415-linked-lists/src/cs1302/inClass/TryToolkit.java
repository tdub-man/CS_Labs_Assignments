package cs1302.inClass;

/**
 * Created by bsetzer on 4/13/2016.
 */
public class TryToolkit {
    public static void main(String[] args) {
        Node n = new Node("c");
        n = new Node("b", n);
        n = new Node("a", n);

        printList(n);

        // size should be 3
        System.out.println("size is " + Toolkit.size(n));

        n = Toolkit.headInsert(n, "x");

        // size should be 4
        System.out.println("size is " + Toolkit.size(n));
        printList(n);

        Node p = n.getNext().getNext();  // third element
        System.out.println("third element is " + p.getDatum());
        Toolkit.insert(p, "g");
        printList(n);   // n is the head of the list!

//        printList(p);


        Node q = n.getNext().getNext().getNext();  // fourth element
        q = Toolkit.insert(q, "r");   // insert after fourth
        q = Toolkit.insert(q, "s");  // insert after new node
        q = Toolkit.insert(q,"t");   // insert after new node
//        Toolkit.insert(Toolkit.insert(Toolkit.insert(q,"r"),"s"),"t");
        printList(n);

    }

    public static void printList(Node head) {
        Node p = head;
        while(p != null) {
            System.out.print(p.getDatum() + " ");
            p = p.getNext();
        }
        System.out.println();
    }
}
