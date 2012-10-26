package li.aop;

import li.ioc.Ioc;
import li.test.BaseTest;

import org.junit.Test;

public class AopTest extends BaseTest {

    @Test
    public void testAop() {
        final Account account = Ioc.get(Account.class);
        account.list(null);
    }

    @Test
    public void testAop2() {
        User user = Ioc.get(User.class);
        System.out.println(user.sayHi("abc", "xyz"));
    }
}