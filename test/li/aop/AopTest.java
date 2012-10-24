package li.aop;

import li.ioc.Ioc;
import li.test.BaseTest;

import org.junit.Test;

public class AopTest extends BaseTest {

    public static void main(String[] args) throws Exception {

        final Account account = Ioc.get(Account.class);
        account.list(null);

        for (int i = 0; i < 100; i++) {
            Thread.sleep(300);
            new Thread() {
                public void run() {
                    for (; true;) {
                        final Account account = Ioc.get(Account.class);
                        account.list(null);
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