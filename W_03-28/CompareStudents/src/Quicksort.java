import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by tanner on 3/31/16.
 */
public class Quicksort {
    public static void sort(ArrayList<Student> list, Comparator<Student> c) {
        quicksort(list,0,list.size()-1,c);
    }
    private static void quicksort(ArrayList<Student> list, int left, int right, Comparator<Student> c) {
        int index = partition(list,left,right,c);
        if (left < index-1) {
            quicksort(list,left,index-1,c);
        }
        if (index < right) {
            quicksort(list,index,right,c);
        }
    }
    private static int partition(ArrayList<Student> list, int left, int right, Comparator<Student> c) {
        int i=left, j=right;
        Student tmp;
        Student pivot = list.get((left+right)/2);

        while(i <= j) {
//            list.get(i) < pivot
            while(c.compare(list.get(i),pivot)<0) {
                ++i;
            }
//            list.get(j) > pivot
            while(c.compare(list.get(j),pivot)>0) {
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
