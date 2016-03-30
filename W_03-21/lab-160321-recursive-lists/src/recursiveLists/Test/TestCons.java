package recursiveLists.Test;

import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 3/19/2016.
 */
public class TestCons {

    private RecList list1, list2, list3;
    private String s1 = "able";


    @Before
    public void setup() {
        String[] a1 = {s1};
        String[] a2 = {"baker", "charlie", "dog", "easy"};
        list1 = RecListSupport.buildFrom(a1);
        list2 = RecListSupport.buildFrom(a2);
        list3 = RecListSupport.buildFrom(a1, a2);
    }

    @Test
    public void consNonEmpty() {
        RecList rl = list2.cons(s1);
        assertEquals("", list3, rl);
    }

    @Test
    public void consToEmpty() {
        RecList rl = RecList.EMPTY.cons(s1);
        assertEquals("", list1, rl );
    }
}
