package recursiveLists.Test;

import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 3/19/2016.
 */
public class TestLast {


    private RecList list1,  list4;
    private String s1 = "able";
    private String s2 = "baker";
    private String s3 = "charlie";
    private String s4 = "dog";

    @Before
    public void setup() {
        String[] sa1 = {s4, s3, s2, s1};
        String[] sa4 = { s4};
        list1 = RecListSupport.buildFrom(sa1);
        list4 = RecListSupport.buildFrom(sa4);
    }


    @Test(expected = Exception.class)
    public void lastOfEmpty() {
        RecList.EMPTY.last();
    }

    @Test
    public void lastOfOne() {
        Object lst = list4.last();
        assertEquals("", s4, lst);
    }

    @Test
    public void lastOfFour() {
        Object lst = list1.last();
        assertEquals("", s1, lst);
    }




}
