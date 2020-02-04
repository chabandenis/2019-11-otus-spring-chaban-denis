package ru.chaban.ex05.domain;

import java.util.UUID;

/*
    мои книги
 */
public class MyBooks {
    private long id;
    private final UUID myBookId;

    public MyBooks(UUID myBookId) {
        this.myBookId = myBookId;
    }

    public MyBooks(long id, UUID myBookId) {
        this.id = id;
        this.myBookId = myBookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getMyBookId() {
        return myBookId;
    }

}
