package bigRational;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Rational implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /**
     * Construct a rational with default properties
     */
    public Rational() {

    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        if(denominator.signum() < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }


    public Rational(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator() {
        return numerator;
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.denominator).add(denominator.multiply(secondRational.numerator));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational negate() {
        return new Rational(numerator.negate(), denominator);
    }


    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
        return this.add(secondRational.negate());
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational divide(Rational secondRational) {
        return multiply(secondRational.reciprocal());
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }


    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (subtract(o).getNumerator().signum() > 0)
            return 1;
        else if (subtract(o).getNumerator().signum() < 0)
            return -1;
        else
            return 0;
    }

    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }




    public Rational pow(int exponent) {
        Rational b = this;
        if(exponent < 0) {
            b = b.reciprocal();
            exponent = - exponent;
        }
        Rational prod = new Rational(1,1);
        for(int i = 0; i < exponent; i++ ) {
            prod = prod.multiply(b);
        }
        return prod;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        else if(!(obj instanceof Rational))
            return false;
        else {
            Rational r = (Rational)obj;
            return r.denominator.equals(this.denominator) && r.numerator.equals(this.numerator);
        }
    }

    @Override
    public int hashCode() {
        return denominator.hashCode() + numerator.hashCode();
    }

    public double doubleValue() {
        BigDecimal n = new BigDecimal(numerator);
        BigDecimal d = new BigDecimal(denominator);
        BigDecimal q = n.divide(d, MathContext.DECIMAL64);
        return q.doubleValue();
    }
}