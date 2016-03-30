package recursiveLists.Test;

import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertEquals;


/**
 * Created by Ben on 3/19/2016.
 */
public class TestDrop {

    private RecList list1, list2, list3, list4;

    @Before
    public void setup() {
        String[] s1 = {"able", "baker", "charlie", "dog"};
        String[] s2 = {"baker", "charlie", "dog"};
        String[] s3 = { "charlie", "dog"};
        String[] s4 = { "dog"};
        list1 = RecListSupport.buildFrom(s1);
        list2 = RecListSupport.buildFrom(s2);
        list3 = RecListSupport.buildFrom(s3);
        list4 = RecListSupport.buildFrom(s4);
    }

    @Test(expected = Exception.class)
    public void dropFromEmpty() {
        RecList.EMPTY.drop(1);
    }

    @Test(expected = Exception.class)
    public void dropTooMany() {
        list1.drop(5);
    }

    @Test
    public void dropNone() {
        RecList rl = list1.drop(0);
        assertEquals("", list1, rl);
    }

    @Test
    public void dropOne() {
        RecList rl = list1.drop(1);
        assertEquals("", list2, rl);
    }

    @Test
    public void dropTwo() {
        RecList rl = list1.drop(2);
        assertEquals("", list3, rl);
    }

    @Test
    public void dropThree() {
        RecList rl = list1.drop(3);
        assertEquals("", list4, rl);
    }

    @Test
    public void dropAll() {
        RecList rl = list1.drop(4);
        assertEquals("", RecList.EMPTY, rl);
    }




}
