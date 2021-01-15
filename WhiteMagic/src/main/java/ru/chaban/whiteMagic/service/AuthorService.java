package ru.chaban.whiteMagic.service;

import ru.chaban.whiteMagic.domain.Author;

import java.util.List;


public interface AuthorService {
    List<Author> findAll();

    List<Author> findByName(String name);
}
