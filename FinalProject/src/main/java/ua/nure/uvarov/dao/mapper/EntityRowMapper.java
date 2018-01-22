package ua.nure.uvarov.dao.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityRowMapper<T> {
    T mapRow(ResultSet resultSet) throws SQLException;
    void unMap(PreparedStatement preparedStatement, T entity) throws SQLException;
}

