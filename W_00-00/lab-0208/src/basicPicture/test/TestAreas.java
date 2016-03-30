package basicPicture.test;

import basicPicture.PicPoint;
import basicPicture.Triangle;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Ben on 2/7/2016.
 */
public class TestAreas {

    public static final double TOLERANCE = 1e-10;

    @Test
    public void triangleTest1() {
        PicPoint p0 = new PicPoint(0,0);
        PicPoint p1 = new PicPoint(3,0);
        PicPoint p2 = new PicPoint(0,4);
        Triangle t = new Triangle(p0, p1, p2);
        double a = t.getArea();
        assertEquals("Triangle area method has an error", 6, Math.abs(a), TOLERANCE);
        assertEquals("Triangle area may not have used absolute value", 6, a, TOLERANCE);
    }

    @Test
    public void triangleTest2() {
        PicPoint p0 = new PicPoint(0,0);
        PicPoint p1 = new PicPoint(17, 23);
        PicPoint p2 = new PicPoint(-25, 47);
        Triangle t = new Triangle(p0, p2, p1);
        double a = t.getArea();
        assertEquals("Triangle area method has an error", 687, Math.abs(a), TOLERANCE);
    }
}
