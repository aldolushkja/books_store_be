package com.aldolushkja.books_store.books.control;

import com.aldolushkja.books_store.books.entity.*;
import com.github.javafaker.Faker;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookInitializer {

    public Faker faker;

    @Inject
    Logger LOGGER;

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        faker = new Faker();
        for (int i = 0; i < 10; i++) {
            buildRandomBook();
        }
    }

    @Transactional
    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
        Book.deleteAll();
    }

    @Transactional
    public void buildRandomBook() {
        Book book = new Book();
        book.title = faker.book().title();
        book.publisher = new Publisher(faker.book().publisher());
        book.publishedAt = faker.date().birthday().toString();
        book.isbn = faker.number().digits(10);
        book.rating = faker.random().nextInt(1, 10);
        book.pages = faker.random().nextInt(100, 500);
        book.prices.add(new Price(faker.random().nextDouble() * 50, "Euro", "€", "EUR"));
        book.description = faker.lorem().paragraph();

        for (int i = 0; i < 3; i++) {
            Genre genre = new Genre();
            genre.name = faker.book().genre();
            if (Math.floor(Math.random() * 10) < 5) {
                book.genres.add(genre);
            }
        }
        Author author = new Author();
        author.name = faker.book().author();
        author.birthDate = faker.date().birthday().toString();

        book.authors.add(author);

        book.persist();
    }
}
