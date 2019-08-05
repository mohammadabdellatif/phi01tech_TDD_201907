package com.phi01tech.um;

public class AddUserHandler {

    public void execute(AddUserInput input) {
        if (!isValidUsername(input.getUsername()))
            throw new InvalidUsernameException();
    }

    private boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty();
    }
}
