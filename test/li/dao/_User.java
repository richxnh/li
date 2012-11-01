package li.dao;

import li.annotation.Bean;
import li.annotation.Table;

@Bean
@Table("t_account")
public class _User extends Record<_User> {
    private static final long serialVersionUID = -2274465783698819130L;

    @li.annotation.Trans
    public void testMultipleTrans2() {
        new Trans() {
            public void run() {
                testMultipleTrans3();
            }
        };
    }

    @li.annotation.Trans
    public void testMultipleTrans3() {
        new Trans() {
            public void run() {
                new Trans() {
                    public void run() {
                        update(new _User().set("id", 2).set("username", "u-5" + System.currentTimeMillis()).set("password", "p-1").set("email", "e-1"));
                    }
                };
            }
        };
    }
}