package ru.chaban.ex05.service;

import ru.chaban.ex05.domain.Book;
import ru.chaban.ex05.domain.MyBooks;

import java.util.List;

public interface MyBooksService {


    List<MyBooks> findAll();

    List<MyBooks> findByName(String name);

    void updateNameById(long id, Book book);

}
