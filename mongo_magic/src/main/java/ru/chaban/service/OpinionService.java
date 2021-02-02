package ru.chaban.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import ru.chaban.domain.Opinion;

import java.util.List;

public interface OpinionService extends MongoRepository<Opinion, String>, OpinionServiceCustom {
//    @Query("select a from Opinion a where a.comment like :comment")
    List<Opinion> findByComment(@Param("comment")String comment);

    List<Opinion> findByCommentIsLikeOrderByCommentDesc(String comment);
}
