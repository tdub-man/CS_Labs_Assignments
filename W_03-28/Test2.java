import java.math.BigInteger;

public class Test2 {
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger GOAL = new BigInteger("1000");
//.pow(744)
    public static void main(String[] args) {
        BigInteger val = new BigInteger("0");
        BigInteger x = new BigInteger("2");
        while(val.compareTo(GOAL) < 1) {
            x = x.add(BigInteger.ONE);
            BigInteger c = collatzBigInt(x);
            System.out.print("C=" + c.toString() + " : ");
            val = (val.compareTo(c)==-1 ? c : val);
            System.out.printf("X=%s : Max=%s\n",x.toString(),val.toString());
        }
    }

    public static double collatz(double n) {
        double val = 0;
        while(n != 1) {
            // if(val>=100) {
            //   System.out.println("\t" + val);
            // }
            if(n%2==0) {
                ++val;
                n = n/2;
            }
            else {
                ++val;
                n = (3*n)+1;
            }
        }

        return val;
    }

    public static BigInteger collatzBigInt(BigInteger b) {
        BigInteger val = new BigInteger("0");
        while(val.compareTo(BigInteger.ONE) != 0){
            if(b.mod(TWO) == BigInteger.ZERO) {
                val = val.add(BigInteger.ONE);
                b = b.divide(BigInteger.valueOf(2));
            }
            else {
                val = val.add(BigInteger.ONE);
                b = b.multiply(THREE).add(BigInteger.ONE);
            }
        }

        return val;
    }

    public static int collatzRec(int n) {
        if(n==1) {
            return 0;
        }
        else if (n%2==0) {
            return collatzRec(n/2)+1;
        }
        else {
            return collatzRec((3*n)+1)+1;
        }
    }
}
