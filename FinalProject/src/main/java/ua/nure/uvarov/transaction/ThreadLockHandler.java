package ua.nure.uvarov.transaction;
import java.sql.Connection;
public class ThreadLockHandler {
    public static final ThreadLocal<Connection> poolConnection = new ThreadLocal<Connection>();

    public static void setConnection(Connection connection) {
        poolConnection.set(connection);
    }

    public static Connection getConnection() {
        return poolConnection.get();
    }
}
