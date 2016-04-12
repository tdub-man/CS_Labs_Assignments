import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Created by tanner on 3/31/16.
 */
public class StudentCompare {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("grades.txt"));
            ArrayList<Student> students = readData(scan);
            Collections.sort(students);
            printData(students);

            Quicksort.sort(students,Student.compareScore1);
            printData(students);

            Quicksort.sort(students,Student.compareScore2);
            printData(students);

            Quicksort.sort(students,Student.compareBothScores);
            printData(students);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
        }
    }

    private static ArrayList<Student> readData(Scanner scan) {
        ArrayList<Student> students = new ArrayList<>();
        while(scan.hasNext()) {
            String name = scan.next();
            int score1 = scan.nextInt();
            int score2 = scan.nextInt();
            Student s = new Student(name,score1,score2);
            students.add(s);
        }

        return students;
    }
    private static void printData(ArrayList<Student> s) {
        System.out.printf("%-10s | %-2s | %-2s | %3s\n","NAME","A","B","SUM");
        System.out.println(new String(new char[27]).replace("\0","-"));
        for(Student st : s) {
            System.out.printf(
                    "%-10s | %2d | %2d | %3d\n",
                    st.getName(),
                    st.getScore1(),
                    st.getScore2(),
                    st.getScore1()+st.getScore2());
        }
        System.out.println(new String(new char[27]).replace("\0","="));
    }

}
