package ua.nure.uvarov.dao.mysql;

import ua.nure.uvarov.constants.MySQL;
import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.dao.BookDao;
import ua.nure.uvarov.dao.mapper.BookRowMapper;
import ua.nure.uvarov.dao.mapper.UserRowMapper;
import ua.nure.uvarov.entity.Book;
import ua.nure.uvarov.entity.BookGroup;
import ua.nure.uvarov.exceptions.DataBaseException;
import ua.nure.uvarov.transaction.ThreadLockHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {


    @Override
    public Book getBookByName(String name) {
       Book book;
       Connection connection = ThreadLockHandler.getConnection();
       try (PreparedStatement st = connection.prepareStatement(MySQL.BOOK_BY_NAME)){
           BookRowMapper bookRowMapper = new BookRowMapper();
           st.setString(1, name);
           st.executeQuery();
           ResultSet resultSet = st.getResultSet();
           resultSet.next();
           book = bookRowMapper.mapRow(resultSet);
       } catch (SQLException e){
           throw new DataBaseException(e);
       }
       return book;
    }

    @Override
    public Book getBookByAuthor(String author) {
        Book book;
        Connection connection = ThreadLockHandler.getConnection();
        try (PreparedStatement st = connection.prepareStatement(MySQL.BOOK_BY_AUTHOR)){
            BookRowMapper bookRowMapper = new BookRowMapper();
            st.setString(1, author);
            st.executeQuery();
            ResultSet resultSet = st.getResultSet();
            resultSet.next();
            book = bookRowMapper.mapRow(resultSet);
        } catch (SQLException e){
            throw new DataBaseException(e);
        }
        return book;
    }


    @Override
    public List<Book> getBooksByGroup(int id) {
        List<Book> list;

        Connection connection = ThreadLockHandler.getConnection();
        try (PreparedStatement st = connection.prepareStatement(MySQL.BOOK_BY_GROUP)){
            list = new ArrayList<>();
            st.setInt(1, id);
            st.executeQuery();
            ResultSet resultSet = st.getResultSet();
            while (!resultSet.isLast())
            resultSet.next();
            list.add(new BookRowMapper().mapRow(resultSet));
        } catch (SQLException e){
            throw new DataBaseException(e);
        }
        return list;
    }

    @Override
    public boolean isUnavailable(int id) {
            Connection connection = ThreadLockHandler.getConnection();
            try (PreparedStatement st = connection.prepareStatement(MySQL.BOOK_AVAILABLE_STATUS)) {
                st.setInt(1, id);
                ResultSet resultSet = st.executeQuery();
                resultSet.next();
                return (resultSet.getInt(Parameters.UNAVAILABLE))==1;
            } catch (SQLException e) {
                throw new DataBaseException(e);
            }
        }

    @Override
    public List<Book> getBooksByGenre(int id) {
        List<Book> list;

        Connection connection = ThreadLockHandler.getConnection();
        try (PreparedStatement st = connection.prepareStatement(MySQL.BOOK_BY_GENRE)){
            list = new ArrayList<>();
            st.setInt(1, id);
            st.executeQuery();
            ResultSet resultSet = st.getResultSet();
            while (!resultSet.isLast())
                resultSet.next();
            list.add(new BookRowMapper().mapRow(resultSet));
        } catch (SQLException e){
            throw new DataBaseException(e);
        }
        return list;
    }

    @Override
    public List<String> getGenres() {
        List<String> list;
        Connection connection = ThreadLockHandler.getConnection();
        try (PreparedStatement st = connection.prepareStatement(MySQL.FIND_ALL_GENRES)){
            list = new ArrayList<>();
            st.executeQuery();
            ResultSet resultSet = st.getResultSet();
            while (!resultSet.isLast())
                resultSet.next();
            list.add(resultSet.getString(1));
        } catch (SQLException e){
            throw new DataBaseException(e);
        }
        return list;
    }



    public Book getById(int id) {
return null;
    }

    public int create(Book book) {
        {
            Connection connection = ThreadLockHandler.getConnection();
            try (PreparedStatement st = connection.prepareStatement(MySQL.CREATE_BOOK, Statement.RETURN_GENERATED_KEYS)) {
                BookRowMapper bookRowMapper = new BookRowMapper();
                bookRowMapper.unMap(st, book);
                st.executeUpdate();
                ResultSet resultSet = st.getGeneratedKeys();
                resultSet.next();
                book.setId(resultSet.getInt(1));
                return book.getId();
            } catch (SQLException e) {
                throw new DataBaseException(e);
            }
        }
    }

    public void update(Book entity) {

    }

    public void delete(Book entity) {

    }
}
