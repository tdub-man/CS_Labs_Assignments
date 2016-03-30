package lab_text_io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Ben on 10/11/2014.
 * Revised by Ben on 9/7//2015
 */
public class WriteTimings {

    private static final int start = 8192;
    private static final int limit = 65536;

    public static void main(String[] args) {
        int reps = 128;
        for(int i=0; i<reps; ++i) {
            System.out.println("Count: " + (i+1));
            timingTest(new BubbleSort());
            timingTest(new InsertionSort());
            timingTest(new ShellSort());
            timingTest(new QuickSort());
        }
    }
    public static void timingTest(Sorting sorter) {
        long l0 = System.nanoTime();

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out/TimingOutput.txt", true)))) {
            out.printf("======================================== : %s\n",sorter.sortingName);
            for(int size = start; size <= limit; size += size) {
                // Sort an Array
                int[] data = RandomArray.generateArray(size, 0, Integer.MAX_VALUE);
                long t0 = System.nanoTime();
                sorter.sort(data);
                long t1 = System.nanoTime();
                long diff = t1 - t0;
//                System.out.printf("%s: array     sort  %d %d %f\n",
//                        sorter.sortingName,size,diff,(double)diff/size/size);
                out.printf("array     sort  %d %d\n",size,diff);

                // Sort an ArrayList
                ArrayList<Integer> data1 = RandomArray.generateArrayList(size,0,Integer.MAX_VALUE);
                t0 = System.nanoTime();
                sorter.sort(data1);
                t1 = System.nanoTime();
                diff = t1 - t0;
//                System.out.printf("%s: arrayList sort  %d %d %f\n",
//                        sorter.sortingName,size,diff,(double)diff/size/size);
                out.printf("arrayList sort  %d %d\n",size,diff);

            }
            out.println("========================================");
        }catch (IOException e) {
            System.out.println("Error opening file");
        }

//        System.out.println("\nWhole Time: " + ((System.nanoTime()-l0)*1E-9) + "\n");
    }
}
