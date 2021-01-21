package ru.chaban.white_magic.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Opinion;

public interface OpinionService extends JpaRepository<Opinion, Long>, OpinionServiceCustom {
}
