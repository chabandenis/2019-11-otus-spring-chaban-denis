package ru.chaban.whiteMagic.service;

import ru.chaban.whiteMagic.domain.Opinion;

import java.util.List;

public interface OpinionService {

    List<Opinion> findAll();

    List<Opinion> findByName(String name);
}
