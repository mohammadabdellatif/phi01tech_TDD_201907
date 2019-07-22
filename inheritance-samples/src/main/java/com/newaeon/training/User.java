package com.newaeon.training;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Object other) {
        // is not null
        if (other == this)
            return true;
        if (other == null)
            return false;
        // is a user
        if (!(other instanceof User)) {
            return false;
        }
        // my username is equals to his username
        User otherUser = (User) other;
        return username.equals(otherUser.username);
    }

    @Override
    public String toString() {
        return super.toString() + " [username=" + username + "]";
    }
}
