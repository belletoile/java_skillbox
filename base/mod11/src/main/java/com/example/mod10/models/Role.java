package com.example.mod10.models;

public enum Role {
    USER, ADMIN;

    public String getAuthority() {
        return name();
    }

}
