package rpnDouble;

import java.util.Stack;

/**
 * Created by Ben on 3/30/2015.
 * Represents a stack oriented calculator.
 *
 */
public class Calculator {
    private Stack<Double> values;

    public Calculator(){
        values = new Stack<>();
    }


    public void add() {
        double a = values.pop();
        double b = values.pop();
        double sum = b + a;
        values.push(sum);
    }


    public void subtract() {
        double a = values.pop();
        double b = values.pop();
        double diff = b - a;
        values.push(diff);
    }

    public double pop() {
        return values.pop();
    }

    public void push(double x) {
        values.push(x);
    }

    public void dup() {
        double a = values.pop();
        values.push(a);
        values.push(a);
    }

    public void swap() {
        double a = values.pop();
        double b = values.pop();
        values.push(a);
        values.push(b);
    }

    public Stack<Double> getStack() {
        return values;
    }
}
