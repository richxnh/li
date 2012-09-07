package li;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllDaoTest.class, AllIocTest.class, AllModelTest.class, AllMvcTest.class, AllServiceTest.class, AllUtilTest.class })
public class FrameworkTest {

}