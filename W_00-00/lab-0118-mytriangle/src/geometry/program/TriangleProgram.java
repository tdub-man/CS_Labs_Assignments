package geometry.program;

import geometry.MyPoint;
import geometry.MyTriangle;

/**
 * Created by Ben on 1/12/2016.
 */
public class TriangleProgram {
    public static void main(String[] args) {
        MyTriangle mt = new MyTriangle();
        MyPoint v0 = new MyPoint();
        v0.setX(3-10);
        v0.setY(0+15);
        mt.setVertex0(v0);
        MyPoint v1 = new MyPoint();
        v1.setX(0-10);
        v1.setY(4+15);
        mt.setVertex1(v1);
        MyPoint v2 = new MyPoint();
        v2.setX(-10);
        v2.setY(15);
        mt.setVertex2(v2);
        System.out.println("the area should be 6: " + mt.area());

    }
}
