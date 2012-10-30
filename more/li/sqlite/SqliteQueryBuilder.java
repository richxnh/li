package li.sqlite;

import javax.sql.DataSource;

import li.dao.QueryBuilder;
import li.model.Bean;

public class SqliteQueryBuilder extends QueryBuilder {
    public SqliteQueryBuilder() {
        super(null, null);
    }

    public SqliteQueryBuilder(DataSource dataSource, Bean beanMeta) {
        super(dataSource, beanMeta);
    }
}