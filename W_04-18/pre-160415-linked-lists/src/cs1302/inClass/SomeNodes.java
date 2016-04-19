package cs1302.inClass;

/**
 * Created by bsetzer on 4/11/2016.
 */
public class SomeNodes {
    public static void main(String[] args) {
        Node n = new Node("a");
        Node nb = new Node("b");
        n.setNext(nb);
        Node nc = new Node("c");
        nb.setNext(nc);

        // n references the head node of a list of three elements
        // nc references the tail node


        // print the elements in the list
        // count the elements in the list


        // Where do we start?   n
        // How do we get to the next element?  .getNext()
        // When do we stop?  when we reach null

        //nb = new Node("not so bad");
        Node p = n;   // start with n
        while(p != null) {
            System.out.println(p.getDatum());
            // goto next node
            p = p.getNext();
        }
    }
}








