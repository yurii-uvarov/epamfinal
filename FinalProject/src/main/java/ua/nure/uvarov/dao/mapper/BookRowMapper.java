package ua.nure.uvarov.dao.mapper;

import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.entity.Book;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements EntityRowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet) throws SQLException {
       Book book = new Book();
        book.setId(resultSet.getInt(Parameters.ID));
        book.setAuthor(resultSet.getString(Parameters.AUTHOR));
        book.setName(resultSet.getString(Parameters.NAME));
        book.setGroupId(resultSet.getInt(Parameters.GROUP));
        book.setPublicationDate(new java.util.Date(resultSet.getDate(Parameters.PUBLICATION_DATE).getTime()));
        book.setEdition(resultSet.getString(Parameters.EDITION));
        book.setGenreId(resultSet.getInt(Parameters.GENRE));
        book.setUnavaliable(resultSet.getInt(Parameters.UNAVAILABLE)==1);
        return book;
    }

    @Override
    public void unMap(PreparedStatement preparedStatement, Book book) throws SQLException {
        preparedStatement.setString(1,book.getName());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setString(3,book.getEdition());
        preparedStatement.setDate(4,new java.sql.Date(book.getPublicationDate().getTime()));
        preparedStatement.setInt(5,book.getGenreId());
        preparedStatement.setInt(6, book.getGroupId());
        preparedStatement.setInt(7,book.isUnavaliable()?1:0);

    }
}
