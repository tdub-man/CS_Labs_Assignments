package geometry.test;





import geometry.MyPoint;
import org.junit.Test;


/**
 * This tests whether the class MyPoint has the right fields and methods.
 * 
 * @author Ben Setzer
 *
 */
public class TestStructure {



    @Test
    public  void testFields() {
        Tests.countFields(MyPoint.class, 2);

    }

    @Test
    public  void testConstructors() {
        Tests.countConstructors(MyPoint.class,1);


    }

    @Test
    public  void testMethods() {
        Tests.countMethods(MyPoint.class, 6);

    }

	

}