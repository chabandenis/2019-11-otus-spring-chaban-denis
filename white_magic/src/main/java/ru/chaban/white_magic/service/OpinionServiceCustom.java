package ru.chaban.white_magic.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OpinionServiceCustom {
    // удалить все комментарии ко всем книгам
    @Transactional
    void customDelete();
}
