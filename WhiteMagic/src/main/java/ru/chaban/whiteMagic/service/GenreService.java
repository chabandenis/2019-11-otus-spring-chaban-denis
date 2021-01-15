package ru.chaban.whiteMagic.service;

import ru.chaban.whiteMagic.domain.Genre;

import java.util.List;

public interface GenreService {


    List<Genre> findAll();

    List<Genre> findByName(String name);

}
