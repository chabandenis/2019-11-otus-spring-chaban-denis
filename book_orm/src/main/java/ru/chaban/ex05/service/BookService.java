package ru.chaban.ex05.service;

import ru.chaban.ex05.domain.Book;

import java.util.List;

public interface BookService {


    List<Book> findAll();

    List<Book> findByName(String name);

    void updateNameById(long id, String name);

}
