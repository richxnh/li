package li.sqlite;

import li.annotation.Table;
import li.dao.QueryBuilder;
import li.dao.Record;

@Table
public class User extends Record<User>{
    protected QueryBuilder getQueryBuilder() {
        return new SqliteQueryBuilder(getDataSource(), getBeanMeta());
    }
}