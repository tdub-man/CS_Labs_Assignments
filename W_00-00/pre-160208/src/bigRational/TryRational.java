package bigRational;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Ben on 9/17/2015.
 */
public class TryRational {
    public static void main(String[] args) {
        Rational r1 = new Rational(2,3);
        System.out.println("r1: " + r1);
        Rational r2 = new Rational(3,4);
        System.out.println("r2: " + r2);
        Rational r3 = r1.add(r2);
        System.out.println("r3: " + r3);
        Rational r4 = r3.subtract(r1);
        System.out.println("r4: " + r4);
        Rational r5 = r1.pow(3);
        System.out.println("r5: " + r5);
        Rational r6 = r1.pow(300);
        System.out.println("r6: " + r6);
        BigDecimal n6 = new BigDecimal(r6.getNumerator());
        BigDecimal d6 = new BigDecimal(r6.getDenominator());
        BigDecimal q6 = n6.divide(d6, MathContext.DECIMAL128);
        System.out.println(q6);
        System.out.println(r6.doubleValue());
    }
}
