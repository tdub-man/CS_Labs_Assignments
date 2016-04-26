package lists.test;

import lists.DList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests if equals works
 *
 * Created by Ben on 4/13/2016.
 */
public class Test05Equals {


    private String values5[] = {"aaa", "bbb", "ccc", "ddd", "eee"};

    @Test
    public void emptyListsEqual() {
        DList lst0 = new DList();
        DList lst1 = new DList();
        assertEquals(lst0, lst1);
    }

    @Test
    public void nonEmptyListsEqual() {
        DList lst0 = new DList();
        for (int i = 0; i < values5.length; i++) {
            lst0.add(i, values5[i]);
        }
        DList lst1 = new DList();
        for (int i = values5.length-1; i >= 0; i--) {
            lst1.add(0, values5[i]);
        }
        assertEquals(lst0,lst1);
    }

    @Test
    public void diffLengthTest() {
        DList lst0 = new DList();
        for (int i = 0; i < values5.length; i++) {
            lst0.add(i, values5[i]);
        }
        DList lst1 = new DList();
        for (int i = values5.length-1; i >= 0; i--) {
            lst1.add(0, values5[i]);
        }
        lst1.add(lst1.size(),"fff");

        assertNotEquals(lst0,lst1);
    }

}
