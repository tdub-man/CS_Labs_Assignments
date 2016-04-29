package rpnDouble.test;

import rpnDouble.Interpreter;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;


/**
 * Created by Ben on 3/30/2015.
 */
public class JTestInterpreter1 {
    public static final double EPS = 1e-10;

    @Test
    public void testProgram1() {
        String program1 = "3 4 + 5 -";
        double[] finalStack1 = {2};
        testProgram(program1, finalStack1);
    }


    @Test
    public void testProgram2() {
        String program = "3 4 5 6 + -";
        double[] fs = {3, -7};
        testProgram(program, fs);
    }


    @Test
    public void testProgram3() {
        String program = "3 dup dup dup + - ";
        double[] fs = {3, -3};
        testProgram(program, fs);
    }


    @Test
    public void testProgram4() {
        String program = "3 dup dup dup + - drop ";
        double[] fs = {3};
        testProgram(program, fs);
    }


    @Test
    public void testProgram5() {
        String program = "3 4 swap - ";
        double[] fs = {1};
        testProgram(program, fs);
    }


    public void testProgram(String program, double[] expectedFinalStack) {
        Interpreter intr = new Interpreter(program);
        intr.exec();
        Stack<Double> stk = intr.getCalculator().getStack();
        assertEquals("program final stack wrong size (" + program + ")",
                expectedFinalStack.length, stk.size(), EPS);
        if (expectedFinalStack.length == stk.size()) {
            for (int i = expectedFinalStack.length - 1; i >= 0; i--) {
                assertEquals("Program final stack has wrong content (" + program + ")",
                        expectedFinalStack[i], stk.pop().doubleValue(), EPS);
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void badOP() {
        String program = "3 4 swp - ";
        double[] fs = {1};
        testProgram(program, fs);
    }


//    @Test(expected = IllegalArgumentException.class)
//    public void badOPx() {
//        String program = "3 4 swap - ";
//        double[] fs = {1};
//        testProgram(program, fs);
//    }

}