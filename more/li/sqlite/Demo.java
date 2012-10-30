package li.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import li.ioc.Ioc;

public class Demo {
    public static void main(String[] args) {
        User user = Ioc.get(User.class);

        System.out.println(user.list(null));
    }

    public static void main2(String[] args) throws Throwable {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite://e:/program files/sqlite/db/forum.db");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}