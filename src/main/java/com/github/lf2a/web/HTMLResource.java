package com.github.lf2a.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <h1>HTMLResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/03/2021
 */
@Path("html")
public class HTMLResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        return "<html><body><h1>Olá Mundo!</h1></body></html>";
    }
}
