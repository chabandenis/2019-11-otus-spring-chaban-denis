package ru.chaban.ex05.domain;

import java.util.UUID;

/*
    автор
 */
public class Author {
    private final UUID id;
    private final String name;

    public Author(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
