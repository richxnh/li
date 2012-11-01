package li.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import li.ioc.Ioc;

public class Demo {

    public static void main(String[] args) {
        final Account dao = Ioc.get(Account.class);

        List<Account> list = dao.list(null);
        // for (Account account : list) {
        // System.out.println(account.get("ID") + "\t" + account.get("USERNAME") + "\t" + account.get("PASSWORD") + "\t" + account.get("EMAIL") + "\t" + account.get("STATUS"));
        // }
    }

    public static void insert() {
        final Account dao = Ioc.get(Account.class);

        for (int i = 0; i < 1000; i++) {
            Account account = new Account().set("USERNAME", "li" + System.currentTimeMillis()).set("PASSWORD", "wode").set("EMAIL", "limingwei@mail.com");
            System.out.println(dao.save(account));
            System.out.println(account.get("ID"));
        }
    }

    static String url = "jdbc:h2:E:/Program Files/h2/db/forum";
    static String username = "sa";
    static String password = "";
    private static final String sql = "CREATE TABLE t_account" + //
            "(id int PRIMARY KEY AUTO_INCREMENT," + //
            "username varchar(255) UNIQUE NOT NULL ," + //
            "password varchar(255) NOT NULL," + //
            "email varchar(255) NOT NULL," + //
            "status int NOT NULL DEFAULT 1)";

    public static void main2(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println(preparedStatement.executeUpdate());
    }
}