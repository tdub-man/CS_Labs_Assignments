package lists.test;

import lists.DList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Add to the end of the list only.
 *
 * Created by Ben on 4/13/2016.
 */
public class Test02AddAndGet {

    @Test
    public void testOneElement() {
        String values[] = {"aaa"};
        DList dl = new DList();
        dl.add(0, values[0]);
        assertEquals(values[0], dl.get(0));

    }

    @Test
    public void testManyElements() {
        String values[] = {"aaa", "bbb", "ccc"};
        DList dl = new DList();
        for (int i = 0; i < values.length; i++) {
            dl.add(i, values[i]);
        }
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], dl.get(i));
        }
    }
}
