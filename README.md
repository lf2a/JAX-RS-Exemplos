# JAX-RS

    Com testes de integração JAX-RS com Apache CXF.

### `@Path`
O valor da anotação `@Path` é um caminho URI relativo que indica onde a classe Java será hospedada: por exemplo `/helloworld`. Você também pode incorporar variáveis ​​nos URIs para fazer um modelo de caminho de URI. Por exemplo, você poderia pedir o nome de um usuário e passá-lo para o aplicativo como uma variável na URI: `/helloworld/{username}`.

### `@GET`
A anotação `@GET` é um designador de método de solicitação e corresponde ao método HTTP GET.

### `@POST`
A anotação `@POST` é um designador de método de solicitação e corresponde ao método HTTP POST.

### `@PUT`
A anotação `@PUT` é um designador de método de solicitação e corresponde ao método HTTP PUT.

### `@DELETE`
A anotação `@DELETE` é um designador de método de solicitação e corresponde ao método HTTP DELETE.

### `@HEAD`
A anotação `@HEAD` é um designador de método de solicitação e corresponde ao método HTTP HEAD.

### `@OPTIONS`
A anotação `@OPTIONS` é um designador de método de solicitação e corresponde ao método HTTP com nome semelhante.

### `@PATCH`
A anotação `@PATCH` é um designador de método de solicitação e corresponde ao método HTTP com nome semelhante.

### `@PathParam`
A anotação `@PathParam` é um tipo de parâmetro que você pode extrair para uso em sua classe de recurso. Os parâmetros do caminho URI são extraídos do URI de solicitação e os nomes dos parâmetros correspondem aos nomes das variáveis ​​do modelo de caminho URI especificados na anotação `@Path` em nível de classe.

### `@QueryParam`
A anotação `@QueryParam` é um tipo de parâmetro que você pode extrair para uso em sua classe de recurso. Os parâmetros de consulta são extraídos dos parâmetros de consulta do URI de solicitação.

### `@Consumes`
A anotação `@Consumes` é usada para especificar os tipos de mídia MIME de representações que um recurso pode consumir e que foram enviadas pelo cliente.

### `@Produces`
A anotação `@Produces` é usada para especificar os tipos de mídia MIME de representações que um recurso pode produzir e enviar de volta ao cliente: por exemplo "`text/plain`".

### `@Provider`
A anotação `@Provider` é usada para qualquer coisa que seja de interesse do tempo de execução JAX-RS, como `MessageBodyReader` e `MessageBodyWriter`. Para solicitações HTTP, `MessageBodyReader` é usado para mapear um corpo de entidade de solicitação HTTP para parâmetros de método. No lado da resposta, um valor de retorno é mapeado para um corpo de entidade de resposta HTTP usando um `MessageBodyWriter`. Se o aplicativo precisar fornecer metadados adicionais, como cabeçalhos HTTP ou um código de status diferente, um método pode retornar um `Response` que envolve a entidade e que pode ser construído usando `Response.ResponseBuilder`.

### `@ApplicationPath`
A anotação `@ApplicationPath` é usada para definir o mapeamento de URL para o aplicativo. O caminho especificado por `@ApplicationPath` é o URI de base para todos os URIs de recursos especificados por anotações `@Path` na classe de recurso. Você só pode aplicar `@ApplicationPath` para uma subclasse de `javax.ws.rs.core.Application`.

### `@Context`
Injeta informações em um campo de classe, propriedade de bean ou parâmetro de método

### `@CookieParam`
Extrai informações de cookies declarados no cabeçalho de solicitação de cookie

### `@FormParam`
Extrai informações de uma representação de solicitação cujo tipo de conteúdo é application/x-www-form-urlencoded

### `@HeaderParam`
Extrai o valor de um cabeçalho

### `@MatrixParam`
Extrai o valor de um parâmetro de matriz URI

### `@PathParam`
Extrai o valor de um parâmetro de modelo de URI

### `@QueryParam`
Extrai o valor de um parâmetro de consulta URI, pode usar `@DefaultValue`