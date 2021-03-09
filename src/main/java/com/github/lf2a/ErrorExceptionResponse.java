package com.github.lf2a;

/**
 * <h1>ErrorExceptionResponse.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/03/2021
 */
public class ErrorExceptionResponse {

    private String field;

    private String message;

    public ErrorExceptionResponse() {
    }

    public ErrorExceptionResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorExceptionResponse{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
