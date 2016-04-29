package rpnBigInt;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by bsetzer on 10/9/2015.
 */
public class Calculator {
    private Deque<BigInteger> calculatorStack = new ArrayDeque<>();

    public Deque<BigInteger> getCalculatorStack() {
        return calculatorStack;
    }

    /**
     * Enter a number into the calculator.
     * It simply gets pushed onto the stack.
     */
    public void push(BigInteger val) {
        calculatorStack.addFirst(val);
    }

    public void push(long val) {
        push(BigInteger.valueOf(val));
    }

    /**
     * Drop the top number from the stack.
     * The value removed is discarded.
     * Precondition: the stack is not empty.
     */
    public void drop() {
        calculatorStack.removeFirst();
    }


    public void add() {
        BigInteger a = calculatorStack.removeFirst();
        BigInteger b = calculatorStack.removeFirst();
        BigInteger result = b.add(a);
        calculatorStack.addFirst(result);
    }


    public void multiply() {
        BigInteger a = calculatorStack.removeFirst();
        BigInteger b = calculatorStack.removeFirst();
        BigInteger result = b.multiply(a);
        calculatorStack.addFirst(result);
    }

    public void subtract() {
        BigInteger a = calculatorStack.removeFirst();
        BigInteger b = calculatorStack.removeFirst();
        BigInteger result = b.subtract(a);
        calculatorStack.addFirst(result);
    }

    public void divide() {
        BigInteger a = calculatorStack.removeFirst();
        BigInteger b = calculatorStack.removeFirst();
        BigInteger result = b.divide(a);
        calculatorStack.addFirst(result);
    }

    public void remainder() {
        BigInteger a = calculatorStack.removeFirst();
        BigInteger b = calculatorStack.removeFirst();
        BigInteger result = b.remainder(a);
        calculatorStack.addFirst(result);
    }

    public void negate() {
        BigInteger a = calculatorStack.removeFirst();
        calculatorStack.addFirst(a.negate());
    }
}
