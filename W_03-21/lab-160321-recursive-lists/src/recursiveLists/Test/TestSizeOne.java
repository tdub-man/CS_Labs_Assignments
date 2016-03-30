package recursiveLists.Test;

import org.junit.Before;
import org.junit.Test;
import recursiveLists.RecList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ben on 3/19/2016.
 */
public class TestSizeOne {

    private RecList list1, list4;

    @Before
    public void setup() {
        String[] s1 = {"able", "baker", "charlie", "dog"};
        String[] s4 = { "dog"};
        list1 = RecListSupport.buildFrom(s1);
        list4 = RecListSupport.buildFrom(s4);
    }

    @Test
    public void sizeOneEmpty() {
        assertFalse(RecList.EMPTY.isSizeOne());
    }

    @Test
    public void sizeOneSizeOne() {
        assertTrue(list4.isSizeOne());
    }

    @Test
    public void sizeOneLonger() {
        assertFalse(list1.isSizeOne());
    }



}
