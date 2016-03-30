package lab_text_io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tanner on 3/15/16.
 */
public class ReadTimingsForKey {
    public static void main(String[] args) {
        System.out.print("Arg Num = " + args.length + ": ");
        for(String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();

        try {
            File txt = new File("out/TimingOutput.txt");
            if (args.length == 2) {
                Scanner scan = new Scanner(txt);
                double[] stat = readData(scan,args[0],args[1]);
                System.out.printf(
                        "\nSortAlg:   %s\nListType:  " +
                                "%s\nAvgFactor: %.5f\nStdDev:    %.5f\nSize:      %.0f",
                        args[0],args[1],stat[0],stat[1],stat[2]);

                scan.close();
            }
            else {
                for(String s : new String[] {"Bubble","Insertion","Shell","Quick"}) {
                    Scanner scan = new Scanner(txt);
                    String sortAlg = s + "Sort";
                    String listType = "arrayList";
                    double[] stat = readData(scan,sortAlg,listType);
                    System.out.printf(
                            "SortAlg:   %s\nListType:  " +
                            "%s\nAvgFactor: %.5f\nStdDev:    %.5f\nSize:      %.0f\n\n",
                            sortAlg,listType,stat[0],stat[1],stat[2]);

                    scan.close();
                }
            }
        }catch (IOException e) {
            System.out.println("Error opening file");
        }
    }
    public static double[] readData(Scanner scanner, String sortAlg, String listType) {
        ArrayList<Double> data = new ArrayList<>();
        while(scanner.hasNext()) {
            if(scanner.nextLine().matches("=+ : "+sortAlg)) {
                while(!scanner.hasNext("=+")) {
                    String l = scanner.findInLine(listType+"\\s+.*");
                    if(l != null) {
                        String[] ls = l.split(" ");
                        long size = Long.valueOf(ls[ls.length-2]);
                        long time = Long.valueOf(ls[ls.length-1]);

//                        double factor = time / Math.pow(size,2);
                        double factor = avgComplexity(sortAlg,size,time);
                        data.add(factor);
//                        System.out.println("Factor: " + factor);

                        scanner.nextLine();
                    }
                    else{
                        scanner.nextLine();
                    }
                }
            }
        }
        double avg = average(data);

        return new double[] {avg,stdDev(data,avg),data.size()};
    }
    private static double avgComplexity(String alg,long size, long time) {
        double factor = 0;
        switch (alg) {
            case "BubbleSort":
            case "InsertionSort": factor = time / Math.pow(size,2); break;
            case "ShellSort": factor = time / Math.pow(size*Math.log(size),2); break;
            case "QuickSort": factor = time / (size*Math.log(size)); break;
        }
        return factor;
    }
    private static double average(ArrayList<Double> data) {
        double sum = 0;
        for(double l : data) {
            sum += l;
        }
        return sum / data.size();
    }
    private static double stdDev(ArrayList<Double> data, double avg) {
        double num = 0;
        for(double l : data) {
            num += Math.pow(l-avg,2);
        }
        return Math.sqrt(num/data.size());
    }
}
