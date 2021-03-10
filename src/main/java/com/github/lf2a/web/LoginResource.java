package com.github.lf2a.web;

import com.github.lf2a.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;

/**
 * <h1>LoginResource.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 10/03/2021
 */
@Path("/login")
public class LoginResource {

    private final SecretKey secretKey = Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6".getBytes(StandardCharsets.UTF_8));

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(User user) {
        try {
            if (user.getName().equals("luiz") && user.getPassword().equals("luiz")) {
                String jwtToken = Jwts.builder()
                        .setSubject(user.getName()) // o login do usuario
                        .setIssuer("localhost:8001") // quem está gerando o token
                        .setIssuedAt(new Date()) // data que o token foi gerado
                        .setExpiration( // validade do token
                                Date.from(
                                        LocalDateTime
                                                .now()
                                                .plusMinutes(15L)
                                                .atZone(ZoneId.systemDefault())
                                                .toInstant()
                                )
                        )
                        .signWith(secretKey, SignatureAlgorithm.HS256) // como o token será assinado
                        .compact();
                return Response.status(Response.Status.OK).entity(jwtToken).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Usuário e/ou senha inválidos").build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
}
