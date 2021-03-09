package com.github.lf2a;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * <h1>IndexResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/03/2021
 */
@Path("")
public class IndexResource {

    @Inject
    @ConfigProperty(name = "message")
    private String message;

    @Context
    private UriInfo context;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response message() {
        return Response.ok(message).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(String body) {
        return Response.ok(body).build();
    }

    @Path("info")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getInfo() {
        String str = "Path:%s\nPath Segments:%s\nRequest URI:%s\nAbsolute Path:%s\nBase URI:%s";
        String ret = String.format(str,
                context.getPath(true),
                context.getPathSegments(true),
                context.getRequestUri(),
                context.getAbsolutePath(),
                context.getBaseUri());
        return Response.ok(ret).build();
    }
}
