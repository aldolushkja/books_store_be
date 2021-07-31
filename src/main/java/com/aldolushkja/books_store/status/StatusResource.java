package com.aldolushkja.books_store.status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("status")
public class StatusResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusInfo(){
        var status = new Status();
        status.status = "Available";
        status.environment = "Development";
        status.version = "1.0.0";
        return Response.ok(status).build();
    }
}
