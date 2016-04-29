package rpnBigInt;

import java.math.BigInteger;

/**
 * Created by bsetzer on 10/9/2015.
 */
public class tryCalculator {
    public static void main(String[] args) {
        Calculator  calc = new Calculator();
        BigInteger a = BigInteger.valueOf(23);
        BigInteger b =  BigInteger.valueOf(14);
        calc.push(a);
        calc.push(b);
        System.out.println("top" + calc.getCalculatorStack() + "bottom");
        calc.push(-33);
        System.out.println("top" + calc.getCalculatorStack() + "bottom");
        calc.drop();
        System.out.println("top" + calc.getCalculatorStack() + "bottom");

    }
}
