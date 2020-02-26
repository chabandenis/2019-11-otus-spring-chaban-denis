package ru.chaban.ex05.service;

import ru.chaban.ex05.domain.Opinion;

import java.util.List;

public interface OpinionService {

    List<Opinion> findAll();

    List<Opinion> findByName(String name);

    void updateNameById(long id, String name);
}
