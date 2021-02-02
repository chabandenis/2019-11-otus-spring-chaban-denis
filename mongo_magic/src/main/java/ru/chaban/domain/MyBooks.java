package ru.chaban.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
    мои книги
 */
@Document
public class MyBooks {
    @Id
    private long id;

/*
    @OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

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
*/

}
