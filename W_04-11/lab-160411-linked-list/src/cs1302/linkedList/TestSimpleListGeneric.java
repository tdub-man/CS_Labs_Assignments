package cs1302.linkedList;

/**
 * Created by tanner on 4/21/16.
 */
public class TestSimpleListGeneric {
    public static void main(String[] args) {
        intTest();
        stringTest();
    }
    private static void intTest() {
        int sum = 0;
        SimpleListGeneric<Integer> slgInt = new SimpleListGeneric<>(
                new Integer[] {0,1,2,3,4,5,6,7,8,9});
        System.out.printf("Size %s: %s ",slgInt.size(),slgInt.toString());
        for(NodeGeneric<Integer> n : slgInt) {
            sum += n.getData();
        }
        System.out.println("Sum: " + sum);

        for(NodeGeneric<Integer> n : slgInt) {
            n.setData(n.getData() * n.getData());
        }
        System.out.printf("Size %s: %s ",slgInt.size(),slgInt.toString());
        sum = 0;
        for(NodeGeneric<Integer> n : slgInt) {
            sum += n.getData();
        }
        System.out.println("Sum: " + sum);
    }
    private static void stringTest() {
        SimpleListGeneric<String> slgString = new SimpleListGeneric<>(
                new String[] {"Abel, Baker, Charlie"});
        System.out.println(slgString.toString());

        slgString.append("Daniel");
        slgString.append("Ellie");
        slgString.append("Fred");
        System.out.println(slgString.toArray()[0]);
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
