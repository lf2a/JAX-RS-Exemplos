package com.github.lf2a;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <h1>User.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/03/2021
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @NotNull(message = "O uso de id é obrigatório")
    private String id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
