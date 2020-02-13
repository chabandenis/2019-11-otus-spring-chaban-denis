package ru.chaban.ex05.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*
    книга
 */
@Entity
@Table(name = "books")
public class Book {

    @Column(name = "name")
    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity = Opinion.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @Column(name = "comments")
    private List<Opinion> comments;



    @ManyToMany
    @JoinTable(name = "link_authors_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id"))
    private List<Author> authors;

    public Book(String name) {
        this.name = name;
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Opinion> getComments() {
        return comments;
    }

    public void setComments(List<Opinion> comments) {
        this.comments = comments;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

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
