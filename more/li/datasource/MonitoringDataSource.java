package li.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MonitoringDataSource implements DataSource {
    private String url;
    private String username;
    private String password;

    private List<Connection> connections = new ArrayList<Connection>();

    static {
        String[] drivers = { "org.sqlite.JDBC" };
        for (String driver : drivers) {
            try {
                Class.forName(driver);
            } catch (Throwable e) {
            }
        }
    }

    public Connection getConnection() throws SQLException {
        return getConnection(this.username, this.password);
    }

    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = new MonitoringConnection(this, DriverManager.getConnection(this.url, username, password));
        connections.add(connection);
        System.err.println("getConnection : 还有未关闭的链接" + connections.size() + "个");
        for (Connection con : connections) {
            System.err.println(con + "\t");
        }
        return connection;
    }

    public void removeConnection(Connection connection) {
        connections.remove(connection);
        System.err.println("removeConnection : 还有未关闭的链接" + connections.size() + "个");
        for (Connection con : connections) {
            System.err.println(con + "\t");
        }
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    public void setLoginTimeout(int seconds) throws SQLException {
    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}