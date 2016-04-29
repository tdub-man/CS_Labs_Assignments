package rpnDouble.test;

import rpnDouble.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;


/**
 * Created by Ben on 3/30/2015.
 */
public class JTestCalculator1 {


    public  final double EPS = 1e-10;

    Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @Test
    public  void testAdd() {
        calc.push(3);
        calc.push(4);
        calc.add();
        double v = calc.pop();
        assertEquals("Add operation incorrect", v, 7, EPS);
    }


    @Test
    public  void testSubtract() {
        calc.push(3);
        calc.push(4);
        calc.subtract();
        double v = calc.pop();
        assertEquals("subtract operation incorrect", v, -1, EPS);
    }

    @Test
    public  void testDup() {
        calc.push(3);
        calc.dup();
        calc.subtract();
        double v = calc.pop();
        assertEquals("dup operation or subtract failed", v, 0, EPS);
    }

    @Test
    public  void testDup2() {
        calc.push(3);
        calc.dup();
        assertEquals("dup operation result top not correct", calc.pop(), 3, EPS);
        assertEquals("dup operation result next to top not correct", calc.pop(), 3, EPS);
    }

    @Test(expected = EmptyStackException.class)
    public void testBadOp() {
        calc.dup();
    }

    @Test(expected = EmptyStackException.class)
    public void testBadOp2() {
        calc.push(3);
        calc.add();
    }

}
