package ru.chaban.ex05v2.domain;

import java.util.List;

/*
    книга
 */
public class Book {
    private final long id;
    private final String name;
    private final List<Author> authors;
    private final List<Genre> genres;

    public Book(long id, String name, List<Author> authors, List<Genre> genres) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.genres = genres;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
