package com.aldolushkja.books_store.books;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Genre extends PanacheEntity{
    public String name;
}
