package com.gustavo.dto;

import com.gustavo.entities.User;

import java.util.Objects;

public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User userObj) {
        this.id = userObj.getId();
        this.name = userObj.getName();
        this.email = userObj.getEmail();
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
