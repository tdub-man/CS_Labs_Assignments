package recursiveLists.Test;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAppendList.class,
        TestCons.class,
        TestDrop.class,
        TestLast.class,
        TestReverse.class,
        TestSizeOne.class,
        TestWithoutLast.class,
})
public class AllTests {


}
