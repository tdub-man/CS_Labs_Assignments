package recursiveLists.Test;


import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 3/19/2016.
 */
public class TestReverse {


    private RecList list1, list2;

    @Before
    public void setup() {
        String[] s1 = {"able", "baker", "charlie", "dog"};
        String[] s2 = {"dog", "charlie", "baker", "able"};
        list1 = RecListSupport.buildFrom(s1);
        list2 = RecListSupport.buildFrom(s2);
     }

    @Test
    public void reverseEmpty() {
        RecList rl = RecList.EMPTY.reverse();
        assertEquals("", RecList.EMPTY, rl);
    }

    @Test
    public void reverseNonEmpty() {
        RecList rl = list1.reverse();
        assertEquals("", list2, rl);
    }
}
