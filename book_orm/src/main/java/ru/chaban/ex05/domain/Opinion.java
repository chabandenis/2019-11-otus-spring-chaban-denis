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

    private long book_id;

    public Opinion(String comment, long book_id) {
        this.comment = comment;
        this.book_id = book_id;
    }

    public String getComment() {
        return comment;
    }

    public long getId() {
        return id;
    }

}
