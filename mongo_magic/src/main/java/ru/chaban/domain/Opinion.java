package ru.chaban.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/*
    Комментарии к книгам
 */
@Document
@Table(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book_id;

    public Opinion(String comment) {
        this.comment = comment;
    }

    public Opinion(String comment, Book book_id) {
        this.comment = comment;
        this.book_id = book_id;
    }

    public Opinion() {
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
