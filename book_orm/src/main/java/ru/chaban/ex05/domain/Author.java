package ru.chaban.ex05.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

/*
    автор
 */
@Entity
@Table(name = "authors")
public class Author {

    @Column(name = "name")
    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

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
