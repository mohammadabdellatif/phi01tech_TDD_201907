package com.phi01tech.um;

import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.handlers.AddUserInput;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class AddUserConsole {

    private AddUserHandler handler;


    public AddUserConsole(AddUserHandler handler) {
        this.handler = handler;
    }

    public void run() {
        System.out.println("enter: username, email, full name");
        String line = new Scanner(System.in).nextLine();
        String[] fields = line.split(",");
        AddUserInput input = new AddUserInput();
        input.setUsername(fields[0]);
        input.setEmail(fields[1]);
        input.setFullName(fields[2]);
        try {
            handler.execute(input);
            System.out.println("user was added successfully");
        } catch (Exception e) {
            String failure = e.getClass().getSimpleName();
            String message = e.getMessage() == null ? StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(failure)) : e.getMessage();
            System.err.println("unable to add user: " + message);
            e.printStackTrace();
        }
    }
}
