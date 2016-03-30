package recursiveLists.Test;

import recursiveLists.RecList;

/**
 * Created by Ben on 3/19/2016.
 */
public class RecListSupport {


    public static RecList buildFrom(Object[] ... ar) {
        RecList rtval = RecList.EMPTY;
        for(int i = ar.length-1; i >= 0; i--) {
            Object[] a = ar[i];
            for(int j = a.length-1; j >= 0;  j--) {
                rtval = RecList.cons(a[j], rtval);
            }
        }
        return  rtval;
    }
}
