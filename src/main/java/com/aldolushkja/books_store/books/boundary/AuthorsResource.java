package com.aldolushkja.books_store.books.boundary;

import com.aldolushkja.books_store.books.entity.Author;
import com.aldolushkja.books_store.interceptors.Loggable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authors")
@Loggable
public class AuthorsResource {

    @GET
    public Response findAll() {
        return Response.ok(Author.getEntityManager().createQuery("select distinct a from Author a order by a.name").getResultList()).build();
    }

}
