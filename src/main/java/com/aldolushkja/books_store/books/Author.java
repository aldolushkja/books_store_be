package com.aldolushkja.books_store.books;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Author extends PanacheEntity {
    
    public String name;

    @Column(name = "birth_date")
    public LocalDate birthDate;
}
