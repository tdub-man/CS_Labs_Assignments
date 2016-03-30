package lab_text_io;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ben on 10/11/2014.
 * Revised by Ben on 9/7/2015
 *
 * Create arrays and lists with random data.
 *
 */
public class RandomArray {



    private static Random gen = new Random();


    /**
     * Generate an array full of randomly generated data.
     * @param size  Size of the array, should be positive
     * @param minData  Smallest value to generate
     * @param maxData  One more than the largest value to generate
     * @return The array filled with data.
     */
    public static int[] generateArray(int size, int minData, int maxData) {
        int[] rtval = new int[size];
        for(int i = 0; i < size; i++ ) {
            rtval[i] = gen.nextInt(maxData-minData) + minData;
        }
        return rtval;
    }

    /**
     * Generate an arrayList full of randomly generated data.
     * @param size  Number of data to generate
     * @param minData  Smallest value to generate
     * @param maxData  One more than the largest value to generate
     * @return The arrayList filled with data.
     */
    public static ArrayList<Integer> generateArrayList(int size, int minData, int maxData) {
        ArrayList<Integer> randArr = new ArrayList<>();
        for(int i=0; i<size; ++i) {
            randArr.add(gen.nextInt(maxData-minData)+minData);
        }
        return randArr;
    }

    public static int[] deDup(int[] arr, int min) {
        int nMin = min-1;
        int dupCount = 0;
        int[] check = new int[arr.length];
        for(int i=0; i<arr.length; ++i) {
            check[i] = arr[i];
        }
        for(int i=0; i<check.length-1; ++i) {
            for(int j=i+1; j<check.length; ++j) {
                if(check[j]==check[i] && check[j] != nMin) {
                    check[j] = nMin;
                    ++dupCount;
                }
            }
        }
        int[] nArr = new int[check.length-dupCount];
        int counter = 0;
        for(int i : check) {
            if(i != nMin) {
                nArr[counter++] = i;
            }
        }

        return nArr;
    }
}
