package com.github.lf2a;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * <h1>UserResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/03/2021
 */
@Path("/users/{username}")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response get(
            @PathParam("username") String username,
            @HeaderParam("author") String author, /* busca um campo do cabeçalho */
            @CookieParam("JSESSIONID") String JSESSIONID /* busca um determinado cookie */) {
        return Response.ok(
                String.format("<html><body><h1>Olá %s!<br><h2>%s</h2><br><h3>%s</h3></h1></body></html>",
                        username, author, JSESSIONID)
        ).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(@FormParam("age") String age /* deve vir em primeiro */, String body) {
        System.out.println(body);
        return Response.ok(String.format("Age: %s", age)).build();
    }
}
