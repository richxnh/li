package li.sqlite;

import li.annotation.Table;
import li.annotation.Trans;
import li.dao.Record;

@Table
public class User extends Record<User> {
    @Trans
    public Boolean save(User t) {
        return super.save(t);
    }
}