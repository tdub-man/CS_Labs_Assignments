/**
 * Created by tanner on 3/31/16.
 */
public class Student {
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
}
