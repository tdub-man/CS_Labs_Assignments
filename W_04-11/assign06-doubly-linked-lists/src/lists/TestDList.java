package lists;

/**
 * Created by tanner on 4/19/16.
 *
 * My own file to test the DList class as I interpret it
 */
public class TestDList {
    public static void main(String[] args) {
        DList list = new DList();
        System.out.println("Size: " + list.size());

        list.add(0,42);
        System.out.print("Size " + list.size() + ": ");
        printList(list);

        list.add(0,21);
        list.add(0,12.5);
        System.out.print("Size " + list.size() + ": ");
        printList(list);

        list.remove(0);
        System.out.print("Size " + list.size() + ": ");
        printList(list);

        list.set(0,0);
        list.set(1,1);
        System.out.print("Size " + list.size() + ": ");
        printList(list);

        System.out.println("toString: " + list.toString());

        for(int i = 2; i<10; ++i) {
            list.add(list.size(),i);
        }
        System.out.println("toString: " + list.toString());


    }

    private static void printList(DList list) {
        for(int i=0; i<list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
