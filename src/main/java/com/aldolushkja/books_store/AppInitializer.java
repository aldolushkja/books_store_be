package com.aldolushkja.books_store;

import com.aldolushkja.books_store.books.entity.*;
import com.aldolushkja.books_store.users.entity.Role;
import com.aldolushkja.books_store.users.entity.User;
import com.github.javafaker.Faker;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class AppInitializer {

    public Faker faker;

    @Inject
    Logger LOGGER;

    @Transactional
    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        faker = new Faker();
        for (int i = 0; i < 10; i++) {
            buildRandomBook();
        }
        buildDefaultUsers();
    }

    private void buildDefaultUsers() {

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role userRole = new Role();
        userRole.setName("USER");
        Role guestRole = new Role();
        guestRole.setName("GUEST");

        adminRole.persist();
        userRole.persist();
        guestRole.persist();

        User admin = new User();
        admin.setUsername("admin");
        admin.setStoredPassword(BCrypt.hashpw("admin", BCrypt.gensalt()));
        admin.addRole(adminRole);
        admin.addRole(userRole);
        admin.persist();

        User guest = new User();
        guest.setUsername("guest");
        guest.setStoredPassword(BCrypt.hashpw("guest", BCrypt.gensalt()));
        guest.addRole(guestRole);
        guest.persist();

        User user = new User();
        user.setUsername("user");
        user.setStoredPassword(BCrypt.hashpw("user", BCrypt.gensalt()));
        user.addRole(userRole);
        user.addRole(guestRole);

        user.persist();

    }

    @Transactional
    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
        Book.deleteAll();
        User.deleteAll();
        Role.deleteAll();
    }

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
