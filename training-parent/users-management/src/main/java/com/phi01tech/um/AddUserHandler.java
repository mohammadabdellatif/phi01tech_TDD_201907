package com.phi01tech.um;

import org.apache.commons.validator.routines.EmailValidator;

public class AddUserHandler {

    public static final String VALID_USERNAME_PATTERN = "[a-zA-Z0-9\\._]{6,}";

    private final UserRepository repository;

    public AddUserHandler(UserRepository repository) {
        this.repository = repository;
    }


    public void execute(AddUserInput input) {
        validInput(input);
        validateUniqueness(input);
        createAndSaveUser(input);
    }

    private void createAndSaveUser(AddUserInput input) {
        User user = createUserFromInput(input);
        repository.save(user);
    }

    private User createUserFromInput(AddUserInput input) {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setFullName(input.getFullName());
        return user;
    }

    private void validInput(AddUserInput input) {
        if (!isValidUsername(input.getUsername()))
            throw new InvalidUsernameException();
        if (!isValidEmail(input.getEmail()))
            throw new InvalidEmailException();
        if (!isValidFullName(input.getFullName()))
            throw new InvalidFullNameException();
    }

    private void validateUniqueness(AddUserInput input) {
        if (!isAvailableUsername(input.getUsername()))
            throw new ReservedUsernameException();
        if (!isAvailableEmail(input.getEmail()))
            throw new UsedEmailException();
    }

    private boolean isAvailableEmail(String email) {
        return !repository.existsByEmail(email);
    }


    private boolean isAvailableUsername(String username) {
        return !repository.existsByUsername(username);
    }

    private boolean isValidFullName(String fullName) {
        return fullName != null && fullName.matches("[^\\s].+");
    }

    private boolean isValidEmail(String email) {
        return email != null && EmailValidator.getInstance().isValid(email);
    }

    private boolean isValidUsername(String username) {
        return username != null && username.matches(VALID_USERNAME_PATTERN);
    }
}
