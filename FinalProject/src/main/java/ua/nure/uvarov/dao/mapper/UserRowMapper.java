package ua.nure.uvarov.dao.mapper;

import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements EntityRowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(Parameters.ID));
        user.setRole(resultSet.getString(Parameters.ROLE));
        user.setFirstName(resultSet.getString(Parameters.FIRST_NAME));
        user.setLastName(resultSet.getString(Parameters.LAST_NAME));
        user.setEmail(resultSet.getString(Parameters.EMAIL));
        user.setBlocked(resultSet.getInt(Parameters.BLOCKED)==1);
        return user;
    }

    @Override
    public void unMap(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1,user.getRole());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getFirstName());
        preparedStatement.setString(5, user.getLastName());
        preparedStatement.setInt(6,user.isBlocked()?1:0);
    }
}
