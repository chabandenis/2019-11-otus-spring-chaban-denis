package ru.chaban.ex05v2.domain;

/*
    массив авторов у книги
 */
public class BookAuthors {
    private final long id;
    private final long bookId;
    private final long authorId;

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
}
