package com.aldolushkja.books_store.books.boundary;

import com.aldolushkja.books_store.books.entity.Publisher;
import com.aldolushkja.books_store.interceptors.Loggable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/publishers")
@Loggable
public class PublishersResource {

    @GET
    public Response findAll() {
        return Response.ok(Publisher.getEntityManager().createQuery("select distinct a from Publisher a order by a.name").getResultList()).build();
    }

}
