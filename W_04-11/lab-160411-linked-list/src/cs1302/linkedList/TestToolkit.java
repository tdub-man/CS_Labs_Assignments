package cs1302.linkedList;

/**
 * Created by tanner on 4/13/16.
 */
public class TestToolkit {
//    Do not use Node constructors
//    Do not use Node.setLink()
    public static void main(String[] args) {
//        Create list with values -56.2 45.9 -35.8 14.7 23.5
        Node head = Toolkit.headInsert(null,23.5);
        head = Toolkit.headInsert(head,14.7);
        head = Toolkit.headInsert(head,-35.8);
        head = Toolkit.headInsert(head,45.9);
        head = Toolkit.headInsert(head,-56.2);
        int size = Toolkit.size(head);

//        Print element three's data
        System.out.println("Third Element: " + Toolkit.locate(head,2).getData());

//        Print the list
        System.out.print("List: ");
        printList(head,size);

//        Add the elements in list and average it
        double sum=0;
        for(int i=0; i<size; ++i) {
            sum += (double) Toolkit.locate(head,i).getData();
            System.out.println("Count: " + i);
        }
        System.out.println("Average: " + sum/5);

//        Add 1 to each element in list
        for(int i=0; i<size; ++i) {
            Node n = Toolkit.locate(head,i);
            n.setData((double) n.getData() + 1);
        }
        System.out.print("List: ");
        printList(head,size);

//        Append new values to list
        double[] newVals = {98.6, -73.2, 85.1, -64.3};
        for(double d : newVals) {
            Toolkit.insert(getLast(head),d);
        }
        size = Toolkit.size(head);
        System.out.print("List: ");
        printList(head,size);

//        Find element of value 24.5 and remove element after it
        Toolkit.remove(Toolkit.search(head,24.5));
        size = Toolkit.size(head);
        System.out.print("List: ");
        printList(head,size);

//        Print value of element at 5th index
        System.out.println("Index 5 Data: " + Toolkit.locate(head,5).getData());

//        Insert new value after the sixth index
        Toolkit.insert(Toolkit.locate(head,6),111.222);
        size = Toolkit.size(head);
        System.out.print("List: ");
        printList(head,size);

//        Remove the second element
        Toolkit.remove(head);
        size = Toolkit.size(head);
        System.out.print("List: ");
        printList(head,size);
    }

    private static void printList(Node head, int size) {
        for (int i=0; i<size; ++i) {
            System.out.print(Toolkit.locate(head,i).getData() + " ");
        }
        System.out.println();

    }
    private static Node getLast(Node head) {
        return Toolkit.locate(head, Toolkit.size(head)-1);
    }
}
