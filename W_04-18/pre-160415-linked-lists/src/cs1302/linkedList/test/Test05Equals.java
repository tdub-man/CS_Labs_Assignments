package cs1302.linkedList.test;


import cs1302.linkedList.SimpleList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests if equals works
 *
 * Created by Ben on 4/13/2016.
 */
public class Test05Equals {


    private String values5[] = {"aaa", "bbb", "ccc", "ddd", "eee"};

    @Test
    public void emptyListsEqual() {
        SimpleList lst0 = new SimpleList();
        SimpleList lst1 = new SimpleList();
        assertEquals(lst0.size(), lst1.size());
        for (int i = 0; i < lst0.size(); i++) {
            assertEquals(lst0.get(i), lst1.get(i));
        }
    }

    @Test
    public void nonEmptyListsEqual() {
        SimpleList lst0 = new SimpleList();
        for (int i = 0; i < values5.length; i++) {
            lst0.add(i, values5[i]);
        }
        SimpleList lst1 = new SimpleList();
        for (int i = values5.length-1; i >= 0; i--) {
            lst1.add(0, values5[i]);
        }
        assertEquals(lst0.size(), lst1.size());
        for (int i = 0; i < lst0.size(); i++) {
            assertEquals(lst0.get(i), lst1.get(i));
        }

    }

}
