package com.github.lf2a;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * <h1>ValidationResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/03/2021
 */
@Path("validation")
public class ValidationResource {

    @Path("/e1")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response e1(@DefaultValue("2021") @QueryParam("year") String year, @NotNull @QueryParam("id") String id) {
        return Response.ok(String.format("[%s] %s", id, year)).build();
    }

    @Path("user")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response e2(@Valid User user) {
        return Response.ok(user).build();
    }
}
