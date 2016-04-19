package lists.test;

import static org.junit.Assert.*;
import lists.DList;
import org.junit.Test;

/**
 * Created by Ben on 4/13/2016.
 */
public class Test01Constructor {

    @Test
    public void testEmpty() {
        DList dl = new DList();
       assertTrue(dl.hasProperStructure());
    }
}
