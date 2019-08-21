package com.phi01tech.um;

import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.handlers.DefaultAddUserHandler;
import com.phi01tech.um.repo.CSVUserRepository;
import com.phi01tech.um.utils.PasswordGenerator;
import com.phi01tech.um.utils.UUIDPasswordGenerator;

import java.nio.file.Paths;

public class Console {

    public static void main(String[] args) {
        UserRepository repository = new CSVUserRepository(Paths.get("./users.csv"));
        PasswordGenerator passwordgenerator = new UUIDPasswordGenerator();
        AddUserHandler handler = new DefaultAddUserHandler(repository, passwordgenerator);
        AddUserConsole console = new AddUserConsole(handler);
        console.run();
    }
}
