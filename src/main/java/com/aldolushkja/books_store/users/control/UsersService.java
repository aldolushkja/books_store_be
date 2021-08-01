package com.aldolushkja.books_store.users.control;

import com.aldolushkja.books_store.users.entity.User;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.logging.Logger;

@ApplicationScoped
public class UsersService {

    @Inject
    Logger LOGGER;

    @ConfigProperty(name = "com.aldolushkja.books_store.users.jwt.duration")
    Long duration;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    public String issuer;


    public String doLogin(AuthRequest authRequest) {
        try {
            TypedQuery<User> query = User.getEntityManager().createQuery("select u from User u where u.username = :username", User.class);
            query.setParameter("username", authRequest.getUsername());
            User currentUser = query.getSingleResult();

            boolean isValidPassword = BCrypt.checkpw(authRequest.getPassword(), currentUser.getStoredPassword());
            if (isValidPassword) {
                String token = TokenUtils.generateToken(currentUser.getUsername(), currentUser.getRoles(), duration, issuer);
                LOGGER.info("User " + currentUser.getUsername() + " authorized to access. Token generated: " + token);
                return token;
            } else {
                return null;
            }

        } catch (Exception e) {
            LOGGER.warning("No user found with username: " + authRequest.getUsername());
            return null;
        }
    }
}
