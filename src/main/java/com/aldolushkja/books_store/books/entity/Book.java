package com.aldolushkja.books_store.books.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book extends PanacheEntity {
    public String title;
    @Column(name = "published_at")
    public String publishedAt;
    public String isbn;

    @Lob
    public String description;
    public int rating;
    public int pages;

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    public Set<Price> prices = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    public Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    public Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_genres",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    public Set<Genre> genres = new HashSet<>();

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishedAt=" + publishedAt +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", pages=" + pages +
                ", prices=" + prices +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }
}
