package ru.chaban.white_magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaban.white_magic.domain.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
