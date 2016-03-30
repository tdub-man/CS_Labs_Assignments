package geometry.test;


import geometry.MyPoint;
import geometry.MyTriangle;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 * Created by Ben on 8/11/2015.
 */
public class TestTriangle {

    private final static double EPS = 1e-10;

    private double[] coords0 = {0,0,  3,0, 0,4};
    private double area0 = 6;

    private MyTriangle t0;

    @Before
    public void init() {
        t0 = fromCoords(coords0);
    }


    public static MyTriangle fromCoords(double[] coords) {
        MyPoint[] verts = new MyPoint[3];
        for (int i = 0; i < verts.length; i++) {
            //verts[i] = new MyPoint(coords[2*i], coords[2*i+1]);
            verts[i] = new MyPoint();
            verts[i].setX(coords[2*i]);
            verts[i].setY(coords[2*i+1]);
        }
        MyTriangle rt = new MyTriangle();
        rt.setVertex0(verts[0]);
        rt.setVertex1(verts[1]);
        rt.setVertex2(verts[2]);
        return rt;
    }



    @Test
    public void testArea() {
        assertEquals("Possible error in MyTriangle area method", area0, t0.area(), EPS);
    }



}
