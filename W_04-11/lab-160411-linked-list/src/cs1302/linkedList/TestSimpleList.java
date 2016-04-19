package cs1302.linkedList;

/**
 * Created by tanner on 4/19/16.
 */
public class TestSimpleList {
    public static void main(String[] args) {
        manualAdd();
        System.out.println();
        arrayAdd();
        System.out.println();
        emptyTest();
    }
    private static void manualAdd() {
        Node head = new Node(24);
        SimpleList list = new SimpleList();
        list.add(0,2);
        list.add(0,1);
        list.add(2,3);
        System.out.printf("Size_%d: %s\n",list.size(),list.toString());
    }
    private static void arrayAdd() {
        System.out.println("First Part:");
        Object[] vals = {0,1,2,3,4};
        SimpleList list = new SimpleList(vals);
        Object[] listToArr = list.toArray();
        System.out.printf(
                "Array Elems: %s\ntoStr Print: %s\ntoArr Print: %s\n",
                printArray(vals),
                list.toString(),
                printArray(listToArr));

        System.out.println("\nSecond Part:");
        list.append(5);
        listToArr = list.toArray();
        System.out.printf(
                "toStr Print: %s\ntoArr Print: %s\n",
                list.toString(),
                printArray(listToArr));

        System.out.println("\nThird Part:");
        list.remove(0);
        listToArr = list.toArray();
        System.out.printf(
                "toStr Print: %s\ntoArr Print: %s\n",
                list.toString(),
                printArray(listToArr));
    }
    private static void emptyTest() {
        Object[] vals = {};
        SimpleList list = new SimpleList(vals);
        Object[] listToArr = list.toArray();
        System.out.printf(
                "Array Elems: %s\ntoStr Print: %s\ntoArr Print: %s\n",
                printArray(vals),
                list.toString(),
                printArray(listToArr));
    }
    private static String printArray(Object[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<arr.length; ++i) {
            sb.append(arr[i]);
            if(i < arr.length-1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
