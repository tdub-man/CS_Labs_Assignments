package recursiveLists.Test;

import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 3/19/2016.
 */
public class TestAppendList {

    private RecList list1, list2, list3;



    @Before
    public void setup() {
        String[] a1 = {"able", "baker", "charlie"};
        String[] a2 = {"dog", "easy"};
        list1 = RecListSupport.buildFrom(a1);
        list2 = RecListSupport.buildFrom(a2);
        list3 = RecListSupport.buildFrom(a1, a2);
    }

    @Test
    public void appendEmpty() {
        RecList rl = list1.append(RecList.EMPTY);
        assertEquals("", list1, rl);
    }

    @Test
    public void appendToEmpty() {
        RecList rl = RecList.EMPTY.append(list2);
        assertEquals("",list2, rl);
    }

    @Test
    public void appendEmpties() {
        RecList rl = RecList.EMPTY.append(RecList.EMPTY);
        assertEquals("",RecList.EMPTY, rl);
    }

    @Test
    public void appendNonEmpty() {
        RecList rl = list1.append(list2);
        assertEquals("", list3, rl);
    }

}
