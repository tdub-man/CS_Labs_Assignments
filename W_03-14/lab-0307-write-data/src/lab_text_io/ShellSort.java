package lab_text_io;

import java.util.ArrayList;

/**
 * Created by tanner on 3/10/16.
 */
public class ShellSort extends Sorting {
    public ShellSort() {
        super("ShellSort");
    }

    @Override
    public void sort(int[] list) {
        int increment = list.length / 2;
        while (increment > 0) {
            for (int i = increment; i < list.length; i++) {
                int j = i;
                int temp = list[i];
                while (j >= increment && list[j - increment] > temp) {
                    list[j] = list[j - increment];
                    j = j - increment;
                }
                list[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
    @Override
    public void sort(ArrayList<Integer> list) {
        int increment = list.size() / 2;
        while (increment > 0) {
            for (int i = increment; i < list.size(); i++) {
                int j = i;
                int temp = list.get(i);
                while (j >= increment && list.get(j - increment) > temp) {
                    list.set(j,list.get(j - increment));
                    j = j - increment;
                }
                list.set(j,temp);
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
