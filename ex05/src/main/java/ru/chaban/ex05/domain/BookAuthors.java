package ru.chaban.ex05.domain;

/*
    массив авторов у книги
 */
public class BookAuthors {
    private long id;
    private final long bookId;
    private final long authorId;

    public BookAuthors(long bookId, long authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public BookAuthors(long id, long bookId, long authorId) {
        this.id = id;
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public long getBookId() {
        return bookId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setId(long id) {
        this.id = id;
    }
}
