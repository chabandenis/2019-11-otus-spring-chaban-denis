package ru.chaban.whiteMagic.service;

import ru.chaban.whiteMagic.domain.MyBooks;

import java.util.List;

public interface MyBooksService {


    List<MyBooks> findAll();

    List<MyBooks> findByName(String name);

}
