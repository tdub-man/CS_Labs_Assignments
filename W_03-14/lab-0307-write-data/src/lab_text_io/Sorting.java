package lab_text_io;

import java.util.ArrayList;

/**
 * Created by tanner on 3/9/16.
 */
public abstract class Sorting {
    final String sortingName;

    public Sorting(String name) {
        sortingName = name;
    }

    public abstract void sort(ArrayList<Integer> list);
    public abstract void sort(int[] list);
}
