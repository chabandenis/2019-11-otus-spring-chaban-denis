package ru.chaban.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*
    Жанр
 */
@Document
public class Genre {

    @Id
    private long id;

    private String name;

/*
    @ManyToMany(mappedBy = "genres")
    private List<Book> books;
*/

    public Genre(String name) {
        this.name = name;
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre(String name, List<Book> books) {
        this.name = name;
//        this.books = books;
    }

    public Genre() {
    }

/*    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
