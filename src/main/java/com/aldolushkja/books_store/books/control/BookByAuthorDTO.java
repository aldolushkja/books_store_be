package com.aldolushkja.books_store.books.control;

public class BookByAuthorDTO {

    public Long id;
    public String title;
    public String authorName;

    public BookByAuthorDTO(Long id, String title, String authorName) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "ByAuthorDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
