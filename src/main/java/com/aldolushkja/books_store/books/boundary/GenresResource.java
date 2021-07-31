package com.aldolushkja.books_store.books.boundary;

import com.aldolushkja.books_store.books.entity.Genre;
import com.aldolushkja.books_store.interceptors.Loggable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/genres")
@Loggable
public class GenresResource {

    @Loggable
    @GET
    public Response findAll() {
        return Response.ok(Genre.getEntityManager().createQuery("select distinct g from Genre g order by g.name").getResultList()).build();
    }

}
