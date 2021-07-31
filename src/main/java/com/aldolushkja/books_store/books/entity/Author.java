package com.aldolushkja.books_store.books.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Author extends PanacheEntity {

    public String name;

    @Column(name = "birth_date")
    public String birthDate;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
