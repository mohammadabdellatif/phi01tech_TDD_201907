package com.phi01tech.um.ws;

import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.handlers.AddUserInput;

public class AddUserHandlerTrack implements AddUserHandler {
    private int success;
    private int failed;
    private AddUserHandler wrapped;

    public AddUserHandlerTrack(AddUserHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void execute(AddUserInput input) {
        try {
            wrapped.execute(input);
            success++;
        } catch (RuntimeException e) {
            failed++;
            throw e;
        }
    }

    public int getSuccess() {
        return success;
    }

    public int getFailed() {
        return failed;
    }
}
