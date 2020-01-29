package ru.chaban.ex05.domain;

import java.util.List;

/*
    книга
 */
public class Book {
    private final long id;
    private final String name;
    private List<Author> authors;
    private List<Genre> genres;

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
