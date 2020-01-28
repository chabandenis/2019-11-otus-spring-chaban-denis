package ru.chaban.ex05.domain;

/*
    Массив жанров у книги
 */
public class BookGenres {
    public long getId() {
        return id;
    }

    private final long id;
    private final long bookId;
    private final long genreId;

    public BookGenres(long id, long bookId, long genreId) {
        this.id = id;
        this.bookId = bookId;
        this.genreId = genreId;
    }

    public long getBookId() {
        return bookId;
    }

    public long getGenreId() {
        return genreId;
    }
}
