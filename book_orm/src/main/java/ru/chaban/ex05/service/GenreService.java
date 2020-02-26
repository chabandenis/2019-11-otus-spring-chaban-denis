package ru.chaban.ex05.service;

import ru.chaban.ex05.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {


    List<Genre> findAll();

    List<Genre> findByName(String name);

    void updateNameById(long id, String name);

}
