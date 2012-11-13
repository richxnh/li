package li.people.record;

import li.annotation.Bean;
import li.annotation.Table;
import li.dao.Record;

@Bean
@Table("t_account")
public class Account extends Record<Account> {
    public Boolean login(Account account) {
        String sql = "WHERE username=? AND password=?";
        return null != find(sql, account.get("username"), account.get("password"));
    }
}