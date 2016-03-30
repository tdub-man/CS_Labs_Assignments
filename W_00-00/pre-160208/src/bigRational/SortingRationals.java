package bigRational;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ben on 9/17/2015.
 */
public class SortingRationals {
    public static void main(String[] args) {
        int limit = 15;
        // create a list of distinct rational numbers
        // Numbers range between 0 and 1, inclusive
        // Denominator is no bigger than limit
        ArrayList<Rational> values = new ArrayList<>();
        for(int d = 1; d < limit; d++ ) {
            for(int n = 0; n <= d; n++ ) {
                Rational r = new Rational(n,d);
                if(!values.contains(r))
                    values.add(r);
            }
        }
        System.out.println(values);
        Collections.sort(values);
        System.out.println(values);
//        for(int i = 0; i < values.size()-1; i++ ) {
//            System.out.println(values.get(i+1).subtract(values.get(i)));
//        }
    }
}
