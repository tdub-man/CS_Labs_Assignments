package recursiveLists.Test;

import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 3/19/2016.
 */
public class TestWithoutLast {

    private RecList list1, list2,  list4;

    @Before
    public void setup() {
        String[] s1 = {"able", "baker", "charlie", "dog"};
        String[] s2 = {"able", "baker", "charlie"};
        String[] s4 = { "dog"};
        list1 = RecListSupport.buildFrom(s1);
        list2 = RecListSupport.buildFrom(s2);
        list4 = RecListSupport.buildFrom(s4);
    }

    @Test(expected = Exception.class)
    public void withoutLastEmpty() {
        RecList.EMPTY.withoutLast();
    }

    @Test
    public void withoutLastOne() {
        RecList rl = list4.withoutLast();
        assertEquals("", RecList.EMPTY, rl);
    }

    @Test
    public void withoutLastLonger() {
        RecList rl = list1.withoutLast();
        assertEquals("", list2, rl);
    }
}
