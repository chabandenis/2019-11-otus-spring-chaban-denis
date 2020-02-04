package ru.chaban.ex05.domain;

import java.util.List;
import java.util.UUID;

/*
    книга
 */
public class Book {
    private final UUID id;
    private final String name;
    private List<Author> authors;
    private List<Genre> genres;

    public Book(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
