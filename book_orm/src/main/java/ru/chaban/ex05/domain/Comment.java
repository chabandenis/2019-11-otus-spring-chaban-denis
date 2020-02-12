package ru.chaban.ex05.domain;

import javax.persistence.*;

/*
    Комментарии к книгам
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_id")
    private final long bookId;

    @Column(name = "comment")
    private String comment;

    public Comment(long bookId, String comment) {
        this.bookId = bookId;
        this.comment = comment;
    }

    public Comment(long id, long bookId, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.comment = comment;
    }

    public long getBookId() {
        return bookId;
    }

    public String getComment() {
        return comment;
    }

    public long getId() {
        return id;
    }
}
