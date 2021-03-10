package com.github.lf2a.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * <h1>ClientApiResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/03/2021
 */
@Path("api")
public class ClientApiResource {

    @Path("/todos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodos() {
        Client client = ClientBuilder.newClient(); // criando a instancia de Client

        String array = client.target("https://jsonplaceholder.typicode.com/todos") // destino da chamada
                .request(MediaType.APPLICATION_JSON) // tipo a ser retornado pela chamada
//                .header("token", "") // definindo um header
//                .cookie("cookie", "") // definindo um cookie
                .get(String.class); // invoca a chamada como um GET

        // ou

        /** Executando de forma assincrona
         * Client client = ClientBuilder.newClient();
         * WebTarget myResource = client.target("https://jsonplaceholder.typicode.com/todos");
         * Future<Customer> fCustomer = myResource.request(MediaType.APPLICATION_JSON)
         *      .async()
         *      .get(new InvocationCallback<Customer>() {
         *             @Override
         *             public void completed(Customer customer) {
         *                  // Do something with the customer object
         *             }
         *
         *             @Override
         *             public void failed(Throwable throwable) {
         *                  // handle the error
         *             }
         *      });
         */

        /**
         * As instâncias de Client são objetos pesados. Por motivos de desempenho, limite o número de instâncias
         * em seu aplicativo, pois a inicialização e destruição dessas instâncias podem ser caras em seu
         * ambiente de tempo de execução.
         */

        return Response.ok(array).build();
    }

}
