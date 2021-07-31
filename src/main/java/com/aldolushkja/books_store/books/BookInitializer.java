package com.aldolushkja.books_store.books;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class BookInitializer {
    
    public Faker faker;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");


    void onStart(@Observes StartupEvent ev) {               
        LOGGER.info("The application is starting...");
        faker = new Faker();
        for(int i = 0; i < 10; i++){
            buildRandomBook();
        }
    }

    @Transactional
    void onStop(@Observes ShutdownEvent ev) {               
        LOGGER.info("The application is stopping...");
        Book.deleteAll();
    }

    @Transactional
    public void buildRandomBook(){
        Book book = new Book();
        book.title = faker.book().title();
        book.publishedAt = LocalDate.now();

        Genre genre = new Genre();
        genre.name = faker.book().genre();

        book.genres.add(genre);

        Author author = new Author();
        author.name = faker.book().author();
        author.birthDate = LocalDate.now();

        book.authors.add(author);

        book.persist();
    }
}
