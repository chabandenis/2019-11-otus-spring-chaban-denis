package ru.chaban.ex05.domain;

/*
    мои книги
 */
public class MyBooks {
    private final long myBookId;
    private long id;

    public MyBooks(long myBookId) {
        this.myBookId = myBookId;
    }

    public MyBooks(long id, long myBookId) {
        this.id = id;
        this.myBookId = myBookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMyBookId() {
        return myBookId;
    }

}
