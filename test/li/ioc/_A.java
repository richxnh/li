package li.ioc;

import li.annotation.Bean;
import li.annotation.Inject;

@Bean("beanA")
public class _A {
    @Inject
    public _A a;
    @Inject
    public _B b;
    @Inject("123")
    public int num;

    public String sayHi(String name) {
        System.out.println("方法被执行 \t name=" + name);
        return "本来的返回值 \t name=" + name;
    }
}