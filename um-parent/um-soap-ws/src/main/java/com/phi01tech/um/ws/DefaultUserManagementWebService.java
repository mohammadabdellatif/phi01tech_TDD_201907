package com.phi01tech.um.ws;

import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.handlers.AddUserInput;

import javax.jws.WebService;

@WebService(endpointInterface = "com.phi01tech.um.ws.UserManagementWebService")
public class DefaultUserManagementWebService implements UserManagementWebService {

// Aspect
    private AddUserHandler handler;

    public DefaultUserManagementWebService(AddUserHandler handler) {
        this.handler = handler;
    }

    @Override
    public Result addUser(UserInfo info) {
        AddUserInput input = new AddUserInput();
        input.setFullName(info.getFirstName() + " " + info.getLastName());
        input.setEmail(info.getEmail());
        input.setUsername(info.getUsername());
        Result result = new Result();
        try {
            handler.execute(input);
            result.setStatus(Result.Status.SUCCCESS);
        } catch (Exception e) {
            result.setStatus(Result.Status.FAILED);
            String message = e.getMessage();
            result.setDescription(message == null ? e.getClass().getSimpleName() : message);
        }
        return result;
    }
}
