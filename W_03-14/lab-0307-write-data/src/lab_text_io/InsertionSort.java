package lab_text_io;

import java.util.ArrayList;

/**
 * Created by tanner on 3/10/16.
 */
public class InsertionSort extends Sorting {
    public InsertionSort() {
        super("InsertionSort");
    }

    @Override
    public void sort(int[] list) {
        int i, j, newVal;
        for(i=1; i<list.length; ++i) {
            newVal = list[i];
            j = i;
            while(j > 0 && list[j-1] > newVal) {
                list[j] = list[j-1];
                --j;
            }
            list[j] = newVal;
        }
    }

    @Override
    public void sort(ArrayList<Integer> list) {
        int i, j, newVal;
        for(i=1; i<list.size(); ++i) {
            newVal = list.get(i);
            j = i;
            while(j > 0 && list.get(j-1) > newVal) {
                list.set(j,list.get(j-1));
                --j;
            }
            list.set(j,newVal);
        }
    }
}
