package ru.chaban.white_magic.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chaban.white_magic.domain.Opinion;

import java.util.List;

public interface OpinionService extends JpaRepository<Opinion, Long>, OpinionServiceCustom {
    @Query("select a from Opinion a where a.comment like :comment")
    List<Opinion> findByComment(@Param("comment")String comment);

    List<Opinion> findByCommentIsLikeOrderByCommentDesc(String comment);
    //CommentContainsOrderByCommentOrderByComment(String comment);
    //ContainsOrderByCommentDesc
}
