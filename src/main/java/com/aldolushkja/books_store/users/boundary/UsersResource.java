package com.aldolushkja.books_store.users.boundary;

import com.aldolushkja.books_store.users.control.AuthRequest;
import com.aldolushkja.books_store.users.control.UsersService;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@RequestScoped
public class UsersResource {

    @Inject
    UsersService usersService;

    @POST
    @Path("/signin")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response signin(AuthRequest authRequest) {
        String token = usersService.doLogin(authRequest);
        if (token == null || token.trim().isBlank()) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Not Authorized").build();
        }
        return Response.ok(Json.createObjectBuilder().add("token", token).build()).build();
    }
}
