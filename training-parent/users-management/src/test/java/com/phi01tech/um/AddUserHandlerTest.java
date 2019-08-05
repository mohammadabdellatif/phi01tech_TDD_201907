package com.phi01tech.um;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

// Requirements:
// inputs:
//  username: unique
//  email: unique
//  full name: required
// output:
//  void
// results
//  user should be notified by email with new generated password
//  user information should be stored in repository
public class AddUserHandlerTest {

    @ParameterizedTest(name = "{index} - [{arguments}]")
    @ArgumentsSource(EmptyStringProvider.class)
    public void givenEmptyUsername_whenExecuteAddUserHandler_thenThrowException(String username) {
        AddUserHandler handler = new AddUserHandler();

        AddUserInput request = new AddUserInput();
        request.setUsername(username);
        Assertions.assertThrows(InvalidUsernameException.class, () -> handler.execute(request));
    }
}
