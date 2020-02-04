package ru.chaban.ex05.domain;

import java.util.UUID;

/*
    Массив жанров у книги
 */
public class BookGenres {
    public long getId() {
        return id;
    }

    private long id;
    private final UUID bookId;
    private final UUID genreId;

    public BookGenres(UUID bookId, UUID genreId) {
        this.bookId = bookId;
        this.genreId = genreId;
    }

    public BookGenres(long id, UUID bookId, UUID genreId) {
        this.id = id;
        this.bookId = bookId;
        this.genreId = genreId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public UUID getGenreId() {
        return genreId;
    }
}
