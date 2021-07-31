package com.aldolushkja.books_store.books;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Book extends PanacheEntity{
    public String title;

    @Column(name = "published_at")
    public LocalDate publishedAt;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "books_authors", 
        joinColumns = { @JoinColumn(name = "book_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    public Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "books_genres", 
        joinColumns = { @JoinColumn(name = "book_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )    
    public Set<Genre> genres = new HashSet<>();
    
}
