package demo;

import li.aop._Account;
import li.ioc.Ioc;

public class T {
    public static void main(String[] args) throws Exception {
        final _Account account = Ioc.get(_Account.class);

        for (int i = 0; i < 1000; i++) {// 开启1000个线程
            new Thread() {
                public void run() {
                    for (; true;) {// 每个线程无限循环
                        account.update("SET password=password");// 这是一个带Aop带Trans的Dao方法
                    }
                }
            }.start();
            Thread.sleep(100);// 每隔0.1秒增加一个线程
        }
    }
}