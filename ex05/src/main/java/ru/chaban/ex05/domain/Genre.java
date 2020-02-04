package ru.chaban.ex05.domain;

import java.util.UUID;

/*
    Жанр
 */
public class Genre {
    private final UUID id;
    private final String name;

    public Genre(UUID id, String name) {
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
