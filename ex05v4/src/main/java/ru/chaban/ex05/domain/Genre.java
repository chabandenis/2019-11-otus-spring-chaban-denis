package ru.chaban.ex05.domain;

/*
    Жанр
 */
public class Genre {
    private final long id;
    private final String name;

    public Genre(long id, String name) {
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
