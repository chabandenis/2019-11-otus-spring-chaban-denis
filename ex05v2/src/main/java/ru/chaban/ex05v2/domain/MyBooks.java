package ru.chaban.ex05v2.domain;

import java.util.List;

/*
    мои книги
 */
public class MyBooks {
    private final long id;
    private final long myBookId;

    public MyBooks(long id, long myBookId) {
        this.id = id;
        this.myBookId = myBookId;
    }

    public long getId() {
        return id;
    }

    public long getMyBookId() {
        return myBookId;
    }

}
