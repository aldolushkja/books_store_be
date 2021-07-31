package com.aldolushkja.books_store.books.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Publisher extends PanacheEntity {

    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }
}
