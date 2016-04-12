import java.util.Comparator;

/**
 * Created by tanner on 3/31/16.
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score1, score2;

    public Student(String name, int score1, int score2) {
        this.name = name;
        this.score2 = score2;
        this.score1 = score1;
    }

    public String getName() {
        return name;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int compareTo(Student s){
        return this.getName().compareTo(s.getName());
    }

    public static Comparator<Student> compareScore1 = (Student a, Student b) -> a.getScore1()-b.getScore1();
    public static Comparator<Student> compareScore2 = (Student a, Student b) -> a.getScore2()-b.getScore2();
    public static Comparator<Student> compareBothScores = (Student a, Student b) -> (a.getScore1()+a.getScore2())-(b.getScore1()+b.getScore2());
}
