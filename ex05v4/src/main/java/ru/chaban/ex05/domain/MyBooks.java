package ru.chaban.ex05.domain;

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
