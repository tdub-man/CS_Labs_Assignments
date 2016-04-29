package rpnBigInt;

import java.math.BigInteger;
import java.util.Deque;

/**
 * Created by bsetzer on 10/9/2015.
 */
public class tryCalcluator4 {
    public static void main(String[] args) {
        // evaluate 3 4 5 6 + *
        // this is not syntactically correct, so ...
        Calculator calc = new Calculator();
        // 3
        calc.push(3);
        // 4
        calc.push(4);
        // 5
        calc.push(5);
        // 6
        calc.push(6);
        System.out.println(calc.getCalculatorStack());
        // +
        calc.add();
        System.out.println(calc.getCalculatorStack());
        // *
        calc.multiply();
        System.out.println(calc.getCalculatorStack());

        // check the final results of the calculation
        Deque<BigInteger> st = calc.getCalculatorStack();
        System.out.println("Check that the stack size is 1: " + st.size());
        System.out.println("The final result is the top: " + st.getFirst());
    }
}
