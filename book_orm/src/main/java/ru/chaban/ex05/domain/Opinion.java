package ru.chaban.ex05.domain;

import javax.persistence.*;

/*
    Комментарии к книгам
 */
@Entity
@Table(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "comment")
    private String comment;

    public Opinion(long bookId, String comment) {
        this.comment = comment;
    }

    public Opinion(long id, long bookId, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public long getId() {
        return id;
    }
}
