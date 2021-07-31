package com.aldolushkja.books_store.books.control;

public class BookByGenreDTO {

    private Long id;
    private String title;
    private String genreName;

    public BookByGenreDTO(Long id, String title, String genreName) {
        this.id = id;
        this.title = title;
        this.genreName = genreName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenreName() {
        return genreName;
    }

    @Override
    public String toString() {
        return "BookByGenreDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
