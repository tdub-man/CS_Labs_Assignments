package geometry.program;

import geometry.MyPoint;

/**
 * Created by Ben on 1/8/2016.
 */
public class PointProgram {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        p1.setX(0);
        p1.setY(0);
        MyPoint p2 = new MyPoint();
        p2.setX(3);
        p2.setY(4);
        System.out.println("Distance from p1 to p2 should be 5: " + p1.distance(p2));
        System.out.println("As should the distance from p2 to p1: " + p2.distance(p1));

        MyPoint p3 = p1.midpoint(p2);
        System.out.println("The x coordinate of p3 should be 1.5: " + p3.getX());
        System.out.println("The y coordinate of p3 should be 2: " + p3.getY());
        System.out.println("The distance from p1 to p3 should be 2.5: " + p1.distance(p3));
        System.out.println("The distance from p2 to p3 should be 2.5: " + p2.distance(p3));
    }
}
