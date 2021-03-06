package com.aldolushkja.books_store.books.control;

public class BookByAuthorDTO {

    private Long id;
    private String title;
    private String authorName;

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
