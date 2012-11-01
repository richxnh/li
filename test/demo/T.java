package demo;

import li.aop._Account;
import li.ioc.Ioc;

public class T {
    public static void main(String[] args) throws Exception {
        final _Account account = Ioc.get(_Account.class);

        for (int i = 0; i < 1000; i++) {
            new Thread() {
                public void run() {
                    for (; true;) {
                        account.update("SET password=password");
                    }
                }
            }.start();
            Thread.sleep(100);
        }
    }
}