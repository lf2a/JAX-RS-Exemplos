package com.github.lf2a.web.filter;

import javax.ws.rs.NameBinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>Authorize.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 10/03/2021
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Authorize {
}
