package ua.nure.uvarov.services;

import ua.nure.uvarov.entity.Book;

import java.util.List;

public interface BookLayer {
    List<String> getGenres();
    List<String> getGroups();
    Book getById(int id);
}
