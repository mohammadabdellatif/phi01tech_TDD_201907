package com.phi01tech.um.handlers;

public class AddUserInput {
    private String username;
    private String email;
    private String fullName;

    public String getUsername() {
        return username;
    }

    public AddUserInput setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AddUserInput setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public AddUserInput setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
