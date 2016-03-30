package geometry.test;

import geometry.MyPoint;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ben on 1/8/2016.
 */
public class TestPoint {

    private double x1 = 0;
    private double y1 = 0;
    private MyPoint p1;
    private double x2 = 3;
    private double y2 = 4;
    private MyPoint p2;
    private double d12 = 5;

    private double x3 = 1.5;
    private double y3 = 2.0;
    private double d13 = 2.5;
    private double d23 = 2.5;

    // tolerance specifies how close we thing computed results should be to actual values.
    private static final double TOLERANCE = 1e-10;

    @Before
    public void setup() {
        p1 = new MyPoint();
        p1.setX(x1);
        p1.setY(y1);
        p2 = new MyPoint();
        p2.setX(x2);
        p2.setY(y2);
    }

    @Test
    public void testDistance12() {
        double d = p1.distance(p2);
        assertEquals("Distance method probably has an error",d12, d, TOLERANCE);
        d = p2.distance(p1);
        assertEquals("Distance method probably has an error",d12, d, TOLERANCE);
    }

    @Test
    public void testMidpointX() {
        MyPoint p3 = p1.midpoint(p2);
        assertEquals("X coordinate of midpoint incorrect", x3, p3.getX(), TOLERANCE);
    }


    @Test
    public void testMidpointY() {
        MyPoint p3 = p1.midpoint(p2);
        assertEquals("Y coordinate of midpoint incorrect", y3, p3.getY(), TOLERANCE);
    }

    @Test
    public void testMidpointDistance() {
        // this is likely to fail if the previous two tests fail.
        // On the other hand, if the previous tests all pass, this one should as well
        MyPoint p3 = p1.midpoint(p2);
        assertEquals("Distance of point to midpoint is incorrect", d13, p1.distance(p3), TOLERANCE);
        assertEquals("Distance of point to midpoint is incorrect", d23, p2.distance(p3), TOLERANCE);

    }


}
