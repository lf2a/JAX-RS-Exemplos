package com.github.lf2a.web;

import com.github.lf2a.web.filter.Authorize;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * <h1>SecuredResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 10/03/2021
 */
@Path("/sec")
public class SecuredResource {

    @Authorize
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response get() {
        return Response.ok("Requisição aceita").build();
    }
}
