package ru.chaban.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*
    автор
 */
@Document
public class Author {

    @Id
    private long id;

    private String name;

/*    @ManyToMany(mappedBy = "authors")
    private List<Book> books;*/

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Book> books) {
        this.name = name;
     /*   this.books = books;*/
    }

    public Author() {
    }

/*
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
*/

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
