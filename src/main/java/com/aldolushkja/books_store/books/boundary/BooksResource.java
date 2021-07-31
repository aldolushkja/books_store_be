package com.aldolushkja.books_store.books.boundary;

import com.aldolushkja.books_store.books.entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
public class BooksResource {
    private static final Logger LOGGER = Logger.getLogger("BooksResource");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(Book.findAll().list()).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        PanacheEntityBase current = Book.findById(id);
        LOGGER.info(current.toString());
        return Response.ok(current).build();
    }
}    
