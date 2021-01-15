package ru.chaban.ex05.domain;

/*
    массив авторов у книги
 */
public class BookAuthors {
    private final long bookId;
    private final long authorId;
    private long id;

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

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public long getAuthorId() {
        return authorId;
    }
}
