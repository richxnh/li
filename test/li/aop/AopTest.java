package li.aop;

import li.ioc.Ioc;
import li.test.BaseTest;

import org.junit.Test;

public class AopTest extends BaseTest {

    public static void main(String[] args) throws Exception {
        final Account account = Ioc.get(Account.class);

        for (int i = 0; i < 1000; i++) {
            new Thread() {
                public void run() {
                    for (; true;) {
                        account.update("SET password=password");
                    }
                }
            }.start();
        }
    }

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