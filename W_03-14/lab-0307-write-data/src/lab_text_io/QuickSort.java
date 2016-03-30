package lab_text_io;

import java.util.ArrayList;

/**
 * Created by tanner on 3/8/16.
 */
public class QuickSort extends Sorting {

    public QuickSort() {
        super("QuickSort");
    }

    @Override
    public void sort(int[] list) {
        quicksort(list,0,list.length-1);
    }
    public static void quicksort(int[] list, int left, int right) {
        int index = partition(list,left,right);
        if (left < index-1) {
            quicksort(list,left,index-1);
        }
        if (index < right) {
            quicksort(list,index,right);
        }
    }
    private static int partition(int[] list, int left, int right) {
        int i=left, j=right;
        int tmp;
        int pivot = list[(left+right)/2];

        while(i <= j) {
            while(list[i] < pivot) {
                ++i;
            }
            while(list[j] > pivot) {
                --j;
            }
            if (i <= j) {
                tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
                ++i;
                --j;
            }
        }

        return i;
    }

    @Override
    public void sort(ArrayList<Integer> list) {
        quicksort(list,0,list.size()-1);
    }
    public static void quicksort(ArrayList<Integer> list, int left, int right) {
        int index = partition(list,left,right);
        if (left < index-1) {
            quicksort(list,left,index-1);
        }
        if (index < right) {
            quicksort(list,index,right);
        }
    }
    private static int partition(ArrayList<Integer> list, int left, int right) {
        int i=left, j=right;
        int tmp;
        int pivot = list.get((left+right)/2);

        while(i <= j) {
            while(list.get(i) < pivot) {
                ++i;
            }
            while(list.get(j) > pivot) {
                --j;
            }
            if (i <= j) {
                tmp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,tmp);
                ++i;
                --j;
            }
        }

        return i;
    }
}
