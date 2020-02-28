package ru.chaban.ex05.service;

import ru.chaban.ex05.domain.Genre;

import java.util.List;

public interface GenreService {


    List<Genre> findAll();

    List<Genre> findByName(String name);

}
