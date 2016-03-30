package lab_text_io;

import java.util.ArrayList;

/**
 * Created by Ben on 10/11/2014.
 * Revised by ben on 9//7/2015
 *
 * Bubble sort on arrays and ArrayLists.
 */
public class BubbleSort extends Sorting {

    public BubbleSort(){
        super("BubbleSort");
    }

    @Override
    public void sort(ArrayList<Integer> list) {
        boolean sorted;
        int top = list.size()-1;
        do {
            sorted = true;
            for(int i=0; i<top; ++i) {
                if(list.get(i) > list.get(i+1)) {
                    int t = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1,t);
                    sorted = false;
                }
            }
            --top;
        } while(!sorted);
    }



     /**
     * An attempt to make the bubble sort more efficient by prefetching values
     * from the ArrayList rather than calling 'get' multiple times.
     *
     *
     */
    @Override
    public void sort(int[] list) {
        boolean sorted;
        int top = list.length-1;
        do {
            sorted = true;  // hope for the best
            for(int i = 0; i < top; i++ ) {
                if(list[i] > list[i+1]) {
                    int t = list[i];
                    list[i] = list[i+1];
                    list[i+1] = t;
                    sorted = false;  // not yet
                }
            }
            top--;
        } while(!sorted);
    }



}
