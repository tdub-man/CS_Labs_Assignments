package Knapsack;

import lab_text_io.QuickSort;
import lab_text_io.RandomArray;
import lab_text_io.SortAndCheck;

import java.util.ArrayList;

/**
 * Created by tanner on 3/16/16.
 */
public class Knapsack {
    private static QuickSort sorter = new QuickSort();
    private static ArrayList<Integer> items = new ArrayList<>();

    public static void main(String[] args) {
        final int limit = 1023;
        boolean different = false;
        int attempts = 0;
//
//        while(!different) {
//            int[] weights = RandomArray.generateArray(15,1,300);
//            sorter.sort(weights);
//            weights = RandomArray.deDup(weights,weights[0]);
//            int max = maximizeLong(weights,limit,weights.length);
//            System.out.println("Attempts: " + (++attempts));
//            if(max < limit) {
//                SortAndCheck.printArray(weights);
//                System.out.printf("Lim: %d\nMax: %d",limit,max);
//                different = true;
//            }
//        }

//        while(!different) {
//            int[] weights = RandomArray.generateArray(15,1,300);
////        int[] weights = {19, 30, 130, 137, 173, 182, 209, 225, 259, 260};
//            sorter.sort(weights);
//            weights = RandomArray.deDup(weights,weights[0]);
//            int max = maxItems(weights,limit,weights.length);
//            System.out.println("Attempts: " + (++attempts));
//            if(max<limit) {
//                System.out.print("Weights: ");
//                SortAndCheck.printArray(weights);
//                System.out.printf("Lim:   %d\nMax:   %d\nItems: ",limit,max);
//                SortAndCheck.printArray(items);
//                System.out.printf("  Sum: %d",sumItems());
//                different = true;
//            }
//        }
    }

//  Greedy alg
    public static int maximizeGreedy(int[] weights, int limit, int upTo) {
        if(limit==0 || upTo==0) {
            return 0;
        }

        int max = 0;
        if(limit >= weights[upTo-1]) {
            max += weights[upTo-1];
            max += maximizeGreedy(weights,limit-weights[upTo-1],upTo-1);
        }

        return max;
    }
//  Long alg
    public static int maximizeLong(int[] weights, int limit, int upTo) {
        int max;
        if(limit==0 || upTo==0) {
            return 0;
        }
        if(weights[upTo-1]>limit) {
            max = maximizeLong(weights,limit,upTo-1);
        }
        else {
            max = Math.max(
                    maximizeLong(weights,limit,upTo-1),
                    maximizeLong(weights,limit-weights[upTo-1],upTo-1)+weights[upTo-1]
                  );
        }

        return max;
    }
    public static int maxItems(int[]weights, int limit, int upTo) {
        int max;
        if(limit==0 || upTo==0) {
            items.clear();
            return 0;
        }
        if(weights[upTo-1]>limit) {
            max = maxItems(weights,limit,upTo-1);
        }
        else {
            int a = maxItems(weights,limit,upTo-1); // Old
            int b = maxItems(weights,limit-weights[upTo-1],upTo-1)+weights[upTo-1]; // New
            if(b > a) {
                max = b;
                items.add(weights[upTo-1]);
            }
            else {
                max = a;
                maxItems(weights,limit,upTo-1);
            }
        }

        return max;
    }

    private static int sumItems() {
        int sum = 0;
        for(int i : items) {
            sum += i;
        }
        return sum;
    }
    private static int maxInArr(ArrayList<Integer> arr) {
        int max = 0;
        for(int i : arr) {
            if(i>max) {
                max = i;
            }
        }
        return max;
    }
}
