package li.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import li.ioc.Ioc;

public class Demo {
    public static void main(String[] args) {
        User userDao = Ioc.get(User.class);

        User user = new User().set("username", "li" + System.currentTimeMillis()).set("password", "wode").set("email", "limw@w.cn");
        userDao.save(user);
        System.out.println(user.get("id"));

        for (User u : userDao.list(null)) {
            System.out.println(u.get("id") + "\t" + u.get("username") + "\t" + u.get("password") + "\t" + u.get("email"));
        }
    }

    public static void main3(String[] args) throws Throwable {
        Class.forName("org.sqlite.JDBC");
        // Connection connection = DriverManager.getConnection("jdbc:sqlite://e:/program files/sqlite/db/forum.db");
        Connection connection = DriverManager.getConnection("jdbc:sqlite://d:/program files/sqlite/db/forum.db");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM user where 1=2");

        ResultSetMetaData meta = resultSet.getMetaData();
        for (int columnCount = (null == meta ? -1 : meta.getColumnCount()), i = 1; i <= columnCount; i++) {
            System.out.println(meta.getColumnName(i));
        }
    }
}