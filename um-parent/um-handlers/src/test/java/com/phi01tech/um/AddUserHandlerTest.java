package com.phi01tech.um;

import com.phi01tech.um.handlers.*;
import com.phi01tech.um.utils.PasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.UUID;

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

    public static final String INDEX_ARGUMENTS = "{index} - [{arguments}]";

    private AddUserHandler handler;
    private UserRepository repository;
    private PasswordGenerator passwordGenerator;

    @BeforeEach
    public void setup() {
        repository = Mockito.mock(UserRepository.class);
        passwordGenerator = Mockito.mock(PasswordGenerator.class);
        handler = new DefaultAddUserHandler(repository, passwordGenerator);
    }

    @ParameterizedTest(name = "{index} - [{arguments}]")
    @ArgumentsSource(InvalidUserNameProvider.class)
    public void givenInputWithInvalidUsername_whenExecuteAddUserHandler_thenThrowException(String username) {
        //TODO have this field to be immutable
        AddUserInput request = new AddUserInput();
        request.setUsername(username);
        Assertions.assertThrows(InvalidUsernameException.class, () -> handler.execute(request));
    }

    @ParameterizedTest(name = INDEX_ARGUMENTS)
    @ArgumentsSource(InvalidEmailProvider.class)
    public void givenInputWithInvalidEmail_whenExecuteAddUserHandler_thenThrowException(String email) {
        AddUserInput input = new AddUserInput();
        input.setUsername("administrator");
        input.setEmail(email);

        Assertions.assertThrows(InvalidEmailException.class, () -> handler.execute(input));
    }

    @ParameterizedTest(name = INDEX_ARGUMENTS)
    @ArgumentsSource(EmptyStringProvider.class)
    public void givenInputWithInvalidFullName_whenExecuteAddUserHandler_thenThrowException(String fullName) {
        AddUserInput input = new AddUserInput();
        input.setUsername("adminstrator");
        input.setEmail("admin@phi.com");
        input.setFullName(fullName);

        Assertions.assertThrows(InvalidFullNameException.class, () -> handler.execute(input));
    }


    @Test
    public void givenValidInputWithUsedUsername_whenExecuteAddUserHandler_thenThrowException() {
        String existUsername = "administrator";

        Mockito.when(repository.existsByUsername(existUsername)).thenReturn(true);

        AddUserInput input = new AddUserInput();

        input.setUsername(existUsername);
        input.setEmail("admin@phi.com");
        input.setFullName("Administrator");

        Assertions.assertThrows(ReservedUsernameException.class, () -> handler.execute(input));
    }

    @Test
    public void givenValidInputWithUsedEmail_whenExecuteAddUserHandler_thenThrowException() {
        Mockito.when(repository.existsByUsername("administrator")).thenReturn(false);
        Mockito.when(repository.existsByEmail("admin@phi.com")).thenReturn(true);

        AddUserInput input = new AddUserInput();
        input.setUsername("administrator");
        input.setEmail("admin@phi.com");
        input.setFullName("Ahmad sami");

        Assertions.assertThrows(UsedEmailException.class, () -> handler.execute(input));
    }

    @Test
    public void givenValidInput_whenExecuteAddUserHandler_thenUserIsPersistedToRepo() {
        // password should be generated randomly
        // email sent with username and password
        String password = UUID.randomUUID().toString();
        Mockito.when(repository.existsByUsername("administrator")).thenReturn(false);
        Mockito.when(repository.existsByEmail("admin@phi.com")).thenReturn(false);
        Mockito.when(passwordGenerator.generate()).thenReturn(password);

        AddUserInput input = new AddUserInput();
        input.setUsername("administrator");
        input.setEmail("admin@phi.com");
        input.setFullName("Ahmad sami");

        handler.execute(input);
        // execution
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        Mockito.verify(repository).save(argument.capture());

        User user = argument.getValue();
        Assertions.assertNotNull(user, "passed user was null");
        Assertions.assertEquals(input.getUsername(), user.getUsername(), "username is not as expected");
        Assertions.assertEquals(input.getEmail(), user.getEmail(), "email is not as expected");
        Assertions.assertEquals(input.getFullName(), user.getFullName(), "full name is not as expected");
        Assertions.assertNotNull(user.getPassword(), "password was not generated");
        Assertions.assertEquals(password, user.getPassword(), "generated password is not as expected");

    }


}
