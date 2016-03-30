package basicPicture.test;

import basicPicture.Circle;
import basicPicture.PicPoint;
import basicPicture.Rectangle;
import basicPicture.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 2/7/2016.
 */
public class TestPerimeters {

    public static final double TOLERANCE = 1e-10;

    @Test
    public void triangleTest1() {
        PicPoint p0 = new PicPoint(0,0);
        PicPoint p1 = new PicPoint(3,0);
        PicPoint p2 = new PicPoint(0,4);
        Triangle t = new Triangle(p0, p1, p2);
        double a = t.getPerimeter();
        assertEquals("Triangle area may not have used absolute value", 12, a, TOLERANCE);
    }

    @Test
    public void triangleTest2() {
        PicPoint p0 = new PicPoint(0,0);
        PicPoint p1 = new PicPoint(17, 23);
        PicPoint p2 = new PicPoint(-25, 47);
        Triangle t = new Triangle(p0, p2, p1);
        double a = t.getPerimeter();
        assertEquals("Triangle area method has an error", 130.20957239876614, Math.abs(a), TOLERANCE);
    }

    @Test
    public void rectangleTest() {
        PicPoint p0  = new PicPoint(0,0);
        Rectangle r = new Rectangle(p0, 12, 13);
        assertEquals("Rectangle perimeter method is incorrect", 50, r.getPerimeter(), TOLERANCE);
    }

    @Test
    public void circleTest() {
        PicPoint p0  = new PicPoint(0,0);
        Circle c = new Circle(p0, 2);
        assertEquals("Circle perimeter method is incorrect", 4*Math.PI, c.getPerimeter(), TOLERANCE);
    }


}
