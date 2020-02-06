package ru.chaban.ex05.domain;

/*
    автор
 */
public class Author {
    private long id;
    private final String name;

    public Author(String name) {
        this.name = name;
    }

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
