package com.aldolushkja.books_store.books.boundary;

import com.aldolushkja.books_store.books.entity.Author;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/authors")
public class AuthorsResource {

    @GET
    public Response findAll() {
        return Response.ok(Author.getEntityManager().createQuery("select distinct a from Author a order by a.name").getResultList()).build();
    }

}
