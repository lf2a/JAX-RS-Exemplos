package com.github.lf2a;

import static com.github.lf2a.JaxrsServerExtension.jaxrsServer;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * <h1>IndexResourcesTests.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/03/2021
 */
public class IndexResourceTest {

    @RegisterExtension
    final JaxrsServerExtension<IndexResource> server = jaxrsServer(IndexResource.class, IndexResource::new)
            .withProvider(new JacksonJsonProvider());

    @Test
    void shouldSayHelloWorldJakartaEE8Test() {
        final Response response = ClientBuilder.newClient()
                .register(new JacksonJsonProvider())
                .target(server.baseUrl())
                .path("")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get();

        assertThat(response.getStatus()).isEqualTo(200);

        final String helloJakarta = response.readEntity(String.class);
        assertThat(helloJakarta.equals("Hello World Jakarta EE 8"));
    }

    @Test
    void shouldBeReturnJSONFormTest() {
        Entity<String> entity = Entity.entity("{\"age\": 20}", MediaType.APPLICATION_JSON);

        final Response response = ClientBuilder.newClient()
                .register(new JacksonJsonProvider())
                .target(server.baseUrl())
                .path("")
                .request()
                .post(entity, Response.class);

        assertThat(response.getStatus()).isEqualTo(200);

        assertThat(response.readEntity(String.class).equals("{\"age\": 20}"));
    }
}
