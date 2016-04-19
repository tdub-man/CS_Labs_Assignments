package cs1302.linkedList.test;


import cs1302.linkedList.SimpleList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Add to the end of the list only.
 *
 * Created by Ben on 4/13/2016.
 */
public class Test02AddAndGet {

    @Test
    public void testOneElement() {
        String values[] = {"aaa"};
        SimpleList dl = new SimpleList();
        dl.add(0, values[0]);
        assertEquals(values[0], dl.get(0));

    }

    @Test
    public void testManyElements() {
        String values[] = {"aaa", "bbb", "ccc"};
        SimpleList dl = new SimpleList();
        for (int i = 0; i < values.length; i++) {
            dl.add(i, values[i]);
        }
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], dl.get(i));
        }
    }
}
