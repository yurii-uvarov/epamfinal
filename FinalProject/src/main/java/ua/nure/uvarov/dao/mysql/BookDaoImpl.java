package ua.nure.uvarov.dao.mysql;

import ua.nure.uvarov.constants.MySQL;
import ua.nure.uvarov.dao.BookDao;
import ua.nure.uvarov.entity.Book;
import ua.nure.uvarov.entity.BookGroup;
import ua.nure.uvarov.exceptions.DataBaseException;
import ua.nure.uvarov.transaction.ThreadLockHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {


    public boolean isExist(String name) {

        return false;
    }

    @Override
    public Book getBookByName(String name) {
       Book book;
       Connection connection = ThreadLockHandler.getConnection();
       try (PreparedStatement st = connection.prepareStatement(MySQL.BOOK_BY_NAME)){
      st.setString(1, name);



       } catch (SQLException e){
           throw new DataBaseException(e);
       }
       return null;
    }

    @Override
    public Book getBookByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> getBooksByGroup(BookGroup group) {
        return null;
    }


    public Book getById(int id) {
return null;
    }

    public int create(Book entity) {
        return 0;
    }

    public void update(Book entity) {

    }

    public void delete(Book entity) {

    }
}
