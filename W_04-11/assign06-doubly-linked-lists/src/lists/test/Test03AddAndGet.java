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
public class Test03AddAndGet {


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


    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeIndexGet() {
        list5.get(-20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeOneIndexGet() {
        list5.get(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testJustTooLargeIndexGet() {
        list5.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testVeryLargeIndexGet() {
        list5.get(500);
    }

    @Test
    public void addInMiddle() {
        int where = 3;
        String what = "fff";
        list5.add(where, what);
        assertTrue(list5.hasProperStructure());
        for (int i = 0; i < where; i++) {
            assertEquals(values5[i], list5.get(i));
        }
        assertEquals(what, list5.get(where));
        for (int i = where+1; i < values5.length; i++) {
            assertEquals(values5[i-1], list5.get(i));
        }
    }


    @Test
    public void addAtStart() {
        int where = 0;
        String what = "fff";
        list5.add(where, what);
        assertTrue(list5.hasProperStructure());
        for (int i = 0; i < where; i++) {
            assertEquals(values5[i], list5.get(i));
        }
        assertEquals(what, list5.get(where));
        for (int i = where+1; i < values5.length; i++) {
            assertEquals(values5[i-1], list5.get(i));
        }
    }



}
