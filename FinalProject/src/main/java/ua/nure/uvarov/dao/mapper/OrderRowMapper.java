package ua.nure.uvarov.dao.mapper;

import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements EntityRowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt(Parameters.ID));
        order.setBookId(resultSet.getInt(Parameters.BOOK_ID));
        order.setUserId(resultSet.getInt(Parameters.USER_ID));
        order.setBorrowDate(new java.util.Date(resultSet.getDate(Parameters.BORROW_DATE).getTime()));
        order.setExpectedDate(new java.util.Date(resultSet.getDate(Parameters.EXPECTED_DATE).getTime()));
        order.setActualDate(new java.util.Date(resultSet.getDate(Parameters.ACTUAL_DATE).getTime()));
        order.setPlace((resultSet.getInt(Parameters.PLACE)) == 0);
        order.setStatus(resultSet.getString(Parameters.STATUS));
        return order;

    }

    @Override
    public void unMap(PreparedStatement preparedStatement, Order order) throws SQLException {
        preparedStatement.setInt(1, order.getId());
        preparedStatement.setInt(2, order.getBookId());
        preparedStatement.setInt(3, order.getUserId());
        preparedStatement.setDate(4, new java.sql.Date(order.getBorrowDate().getTime()));
        preparedStatement.setDate(5, new java.sql.Date(order.getExpectedDate().getTime()));
        preparedStatement.setDate(6, new java.sql.Date(order.getActualDate().getTime()));
        preparedStatement.setInt(7, order.isPlace() ? 0 : 1);

    }
}
