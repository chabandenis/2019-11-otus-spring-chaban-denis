package ru.chaban.ex05.domain;

import javax.persistence.*;

/*
    мои книги
 */
@Entity
@Table(name = "my_books")
public class MyBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private final long bookId;

    public MyBooks(long myBookId) {
        this.bookId = myBookId;
    }

    public MyBooks(long id, long myBookId) {
        this.id = id;
        this.bookId = myBookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMyBookId() {
        return bookId;
    }

}
