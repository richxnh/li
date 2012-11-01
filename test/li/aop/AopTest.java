package li.aop;

import li.ioc.Ioc;
import li.test.BaseTest;

import org.junit.Test;

public class AopTest extends BaseTest {

    @Test
    public void testAop() {
        final _Account account = Ioc.get(_Account.class);
        account.list(null);
    }

    @Test
    public void testAop2() {
        _User user = Ioc.get(_User.class);
        System.out.println(user.sayHi("abc", "xyz"));
    }
}