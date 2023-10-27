package com.mod5;

public class User {
    private String login;
    private String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public boolean setLogin(String login) {
        if(login.length() < 5)
            return false;

        this.login = login;
        return true;
    }

    public boolean setEmail(String email) {
        if(!email.contains("@") || !email.contains("."))
            return false;
        this.email = email;
        return true;
    }
}
