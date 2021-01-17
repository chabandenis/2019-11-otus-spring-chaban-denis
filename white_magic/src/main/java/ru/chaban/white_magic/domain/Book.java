package ru.chaban.white_magic.domain;

import javax.persistence.*;
import java.util.List;

/*
    книга
 */
@Entity
@Table(name = "books")
public class Book {

    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(targetEntity = Opinion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private List<Opinion> comments;

    @ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinTable(name = "arr_authors_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id"))
    private List<Author> authors;

    @ManyToMany(targetEntity = Genre.class, fetch = FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinTable(name = "arr_authors_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    public Book(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
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
