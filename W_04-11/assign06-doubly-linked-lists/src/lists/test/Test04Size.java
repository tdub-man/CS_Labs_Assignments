package lists.test;

import lists.DList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * More extensive tests of add a nd get
 *
 * Created by Ben on 4/13/2016.
 */
public class Test04Size {


    private DList list0, list1, list5;
    private String values5[] = {"aaa", "bbb", "ccc", "ddd", "eee"};

    @Before
    public void setup() {
        list0 = new DList();


        list5 = new DList();
        for (int i = 0; i < values5.length; i++) {
            list5.add(i, values5[i]);
        }

        list1 = new DList();
        list1.add(0, "rrr");


    }

    @Test
    public void testEmptySize() {
        assertEquals(0, list0.size());
    }

    @Test
    public void testNonEmptySize() {
        assertEquals(values5.length, list5.size());
    }


}
