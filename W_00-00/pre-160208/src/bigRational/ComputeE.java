package bigRational;

import java.math.BigInteger;

/**
 * Created by Ben on 9/17/2015.
 */
public class ComputeE {

    public static void main(String[] args) {
        int limit = 20;
        BigInteger denom = BigInteger.ONE;
        int n = 1;
        Rational sum = new Rational();
        while(n <= limit) {
            sum = sum.add(new Rational(BigInteger.ONE, denom));
            System.out.println(sum.doubleValue());
            denom = denom.multiply(BigInteger.valueOf(n));
            n++;
        }
    }


}
