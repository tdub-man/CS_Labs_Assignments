package lab_text_io;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 10/11/2014.
 * Revised by Ben on 9/7/2015
 *
 * A quick check that the sort methods work properly.
 *
 * The output should be something like this:
 *
 * Result off sortArray: 199 out of 200
 * Result of sortArrayList: 199 out of 200
 *
 *   If the first number in either part is -1 (rather than 199) then the sort routine
 *      did not actually sort the numbers: the numbers are still out of order
 *   If the first number in either part is a lot less than 199 (smaller than 195, say) then
 *      the random generation routine is probably not working properly
 *
 */
public class SortAndCheck {


    private static final int size = 200;

    public static void main(String[] args) {
        sortArray(new BubbleSort());
        sortArrayList(new BubbleSort());

        sortArray(new QuickSort());
        sortArrayList(new QuickSort());

        sortArray(new InsertionSort());
        sortArrayList(new InsertionSort());

        sortArray(new ShellSort());
        sortArrayList(new ShellSort());
    }



    public static void sortArray(Sorting sorter) {
        int[] data = RandomArray.generateArray(size, 0, Integer.MAX_VALUE);
        sorter.sort(data);
        int x = checkSorted(data);
        System.out.println("Result of sortArray:     " + x + " out of " + size);
    }


    public static void sortArrayList(Sorting sorter) {
        ArrayList<Integer> data = RandomArray.generateArrayList(size, 0, Integer.MAX_VALUE);
        sorter.sort(data);
        int x = checkSorted(data);
        System.out.println("Result of sortArrayList: " + x + " out of " + size);
    }

    /**
     * Check if list is sorted into ascending order.
     * @return Return -1 if the list is not sorted properly.
     *  Otherwise return the number of pairs of adjacent elements
     *  which are equal.
     */
    public static int checkSorted(int[] list){
        int count = 0;
        for(int i = 0;i < list.length-1; i++ ) {
            if(list[i] > list[i+1]) {
                return -1;
            } else if(list[i] < list[i+1]) {
                count++;
            } else {
                // nothing
            }
        }
        return count;
    }

    /**
     * Check if list is sorted into ascending order.
     * @return Return -1 if the list is not sorted properly.
     *  Otherwise return the number of pairs of adjacent elements
     *  which are equal.
     */
    public static int checkSorted(ArrayList<Integer> list) {
        int count = 0;
        for(int i = 0; i < list.size()-1; i++ ) {
            if(list.get(i) > list.get(i+1)) {
                return -1;
            } else if(list.get(i) < list.get(i+1)) {
                count++;
            } else {
                // do nothing
            }
        }
        return count;
    }

    public static void printArray(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printArray(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
