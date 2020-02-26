package ru.chaban.ex05.service;

import ru.chaban.ex05.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    List<Author> findByName(String name);

    void updateNameById(long id, String name);
}
