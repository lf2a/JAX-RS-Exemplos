package com.github.lf2a;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h1>MyExceptionMapper.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/03/2021
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(prepareMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private List<ErrorExceptionResponse> prepareMessage(ConstraintViolationException exception) {
        List<ErrorExceptionResponse> errorMessages = new ArrayList<>();

        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            Path path = cv.getPropertyPath();
            Iterator<Path.Node> pathIterator = path.iterator();
            String fieldName = "";

            while (pathIterator.hasNext()) {
                fieldName = pathIterator.next().getName();
            }

            errorMessages.add(new ErrorExceptionResponse(fieldName, cv.getMessage()));
        }

        return errorMessages;
    }
}
