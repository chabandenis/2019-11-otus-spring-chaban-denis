package ru.chaban.ex05.domain;

import java.util.UUID;

/*
    массив авторов у книги
 */
public class BookAuthors {
    private long id;
    private final UUID bookId;
    private final UUID authorId;

    public BookAuthors(UUID bookId, UUID authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public BookAuthors(long id, UUID bookId, UUID authorId) {
        this.id = id;
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public UUID getBookId() {
        return bookId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setId(long id) {
        this.id = id;
    }
}
