package ru.chaban.ex05.domain;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

/*
    мои книги
 */
@Entity
@Table(name = "my_books")
@Transactional
public class MyBooks {
    @OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public MyBooks(Book book) {
        this.book = book;
    }

    public MyBooks() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
