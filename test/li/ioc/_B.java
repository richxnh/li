package li.ioc;

import li.annotation.Bean;
import li.annotation.Inject;

@Bean
public class _B {
    @Inject
    private _A a;

    @Inject
    private _B b;
}