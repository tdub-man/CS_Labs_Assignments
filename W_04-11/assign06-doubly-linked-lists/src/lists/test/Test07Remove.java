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
public class Test07Remove {


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
    public void testNegativeIndexRemove() {
        list5.remove(-20);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeOneIndexRemove() {
        list5.remove(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testJustTooLargeIndexRemove() {
        list5.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testVeryLargeIndexRemove() {
        list5.remove(500);
    }

    @Test
    public void removeInMiddle() {
        int where = 3;
        list5.remove(where);
        assertTrue(list5.hasProperStructure());
        for (int i = 0; i < where; i++) {
            assertEquals(values5[i], list5.get(i));
        }
        for (int i = where+1; i < values5.length; i++) {
            assertEquals(values5[i], list5.get(i-1));
        }
    }


    @Test
    public void removeAtStart() {
        int where = 0;
        list5.remove(where);
        assertTrue(list5.hasProperStructure());
        for (int i = 0; i < where; i++) {
            assertEquals(values5[i], list5.get(i));
        }
        for (int i = where+1; i < values5.length; i++) {
            assertEquals(values5[i], list5.get(i-1));
        }
    }


    @Test
    public void removeAtEnd() {
        int where = 3;
        list5.remove(where);
        assertTrue(list5.hasProperStructure());
        for (int i = 0; i < where; i++) {
            assertEquals(values5[i], list5.get(i));
        }
        for (int i = where+1; i < values5.length; i++) {
            assertEquals(values5[i], list5.get(i-1));
        }
    }

    @Test
    public void removeFromSizeOne() {
        list1.remove(0);
        assertTrue(list1.hasProperStructure());
        assertEquals(list1.size(),0);
    }

}
