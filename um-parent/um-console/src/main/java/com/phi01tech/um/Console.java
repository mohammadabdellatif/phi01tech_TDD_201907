package com.phi01tech.um;

import com.phi01tech.um.repo.CSVUserRepository;

import java.nio.file.Paths;
import java.util.UUID;

public class Console {

    public static void main(String[] args) {
        UserRepository repository = new CSVUserRepository(Paths.get("./users.csv"));
        PasswordGenerator passwordgenerator = () -> UUID.randomUUID().toString();
        AddUserHandler handler = new AddUserHandler(repository, passwordgenerator);
        AddUserConsole console = new AddUserConsole(handler);
        console.run();
    }
}
