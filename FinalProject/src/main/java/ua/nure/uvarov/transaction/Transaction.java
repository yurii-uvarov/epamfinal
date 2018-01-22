package ua.nure.uvarov.transaction;

import java.sql.SQLException;

public interface Transaction<T> {
    T execute() throws SQLException;
}
