package ru.chaban.ex05.domain;

import javax.persistence.*;

/*
    мои книги
 */
@Entity
@Table(name = "my_books")
public class MyBooks {
    @OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private final long bookId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getBookId() {
        return bookId;
    }

    public MyBooks(long myBookId) {
        this.bookId = myBookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
