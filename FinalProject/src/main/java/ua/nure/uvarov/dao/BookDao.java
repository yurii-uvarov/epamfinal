package ua.nure.uvarov.dao;

import ua.nure.uvarov.entity.Book;
import ua.nure.uvarov.entity.BookGroup;

import java.util.List;


public interface BookDao extends GenericDao<Book> {
    Book getBookByName(String name);
    Book getBookByAuthor(String author);
    List<Book> getBooksByGroup(BookGroup group);

}
