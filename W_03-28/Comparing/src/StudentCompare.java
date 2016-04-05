import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by tanner on 3/31/16.
 */
public class StudentCompare {
    public static void main(String[] args) {
        try {
            File data = new File("grades.txt");
            Scanner scan = new Scanner(data);
            ArrayList<Student> students = readData(scan);


        } catch (IOException e) {
            System.out.println();
        }
    }

    public static ArrayList<Student> readData(Scanner scan) {
        ArrayList<Student> students = new ArrayList<>();
        while(scan.hasNext()) {
            String name = scan.next();
            int score1 = scan.nextInt();
            int score2 = scan.nextInt();
            Student s = new Student(name,score1,score2);
            students.add(s);
            scan.nextLine();
        }

        return students;
    }
}
