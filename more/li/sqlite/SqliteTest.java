package li.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import li.ioc.Ioc;
import li.test.BaseTest;
import li.util.Page;

import org.junit.Test;

public class SqliteTest extends BaseTest {
    @Test
    public void test() {
        User userDao = Ioc.get(User.class);

        User user = new User().set("username", "li" + System.currentTimeMillis()).set("password", "wode").set("email", "limw@w.cn");
        userDao.save(user);

        userDao.save(user);

        user = new User().set("username", "li" + System.currentTimeMillis()).set("password", "wode").set("email", "limw@w.cn");
        userDao.save(user);

        System.out.println("user id = " + user.get("id"));

        Page page = new Page(1, 5);

        for (User u : userDao.list(page, "ORDER BY id DESC")) {
            System.out.println(u.get("id") + "\t" + u.get("username") + "\t" + u.get("password") + "\t" + u.get("email"));
        }

        System.out.println("RecordCount = " + page.getRecordCount());
    }

    // @Test
    public void insert() {
        final User dao = Ioc.get(User.class);

        for (int i = 0; i < 1000; i++) {
            User user = new User().set("username", "li" + System.currentTimeMillis()).set("password", "wode").set("email", "limw@w.cn");
            System.out.println(dao.save(user) + "\t" + user.get("id"));
        }
    }

    public void connection() throws Throwable {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:../../Program Files/sqlite/db/forum.db");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM user where 1=2");

        ResultSetMetaData meta = resultSet.getMetaData();
        for (int columnCount = (null == meta ? -1 : meta.getColumnCount()), i = 1; i <= columnCount; i++) {
            System.out.println(meta.getColumnName(i));
        }
    }
}
