package ru.chaban.whiteMagic.service;

import ru.chaban.whiteMagic.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    List<Book> findByName(String name);

}
