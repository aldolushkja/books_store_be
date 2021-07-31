package com.aldolushkja.books_store.books.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Price extends PanacheEntity {
    private double value;
    private String currency;
    private String symbol;
    private String code;

    public Price(double value, String currency, String symbol, String code) {
        this.value = value;
        this.currency = currency;
        this.symbol = symbol;
        this.code = code;
    }

    public Price() {

    }

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                ", symbol='" + symbol + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
