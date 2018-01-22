package ua.nure.uvarov.transaction;

import ua.nure.uvarov.exceptions.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private DataSource dataSource;

    public DBManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T execute(Transaction<T> transaction) {
        Connection con = null;
        try{
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ThreadLockHandler.setConnection(con);
            T value = transaction.execute();
            con.commit();
            return value;
        } catch (Throwable e) {
            tryToRollback(con);
            throw new AppException(e);// AppException
        } finally {
            ThreadLockHandler.setConnection(null);
            tryToClose(con);
        }

    }

    private void tryToRollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                throw new AppException(e);
            }
        }

    }

    private void tryToClose(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new AppException(e);
            }
        }

    }
}

