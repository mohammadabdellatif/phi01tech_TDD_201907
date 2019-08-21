package com.phi01tech.um.rest;

import com.phi01tech.um.UserRepository;
import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.handlers.DefaultAddUserHandler;
import com.phi01tech.um.repo.CSVUserRepository;
import com.phi01tech.um.utils.PasswordGenerator;
import com.phi01tech.um.utils.UUIDPasswordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class AppConfiguration {

    @Bean
    public PasswordGenerator passwordGenerator() {
        return new UUIDPasswordGenerator();
    }

    @Bean
    public UserRepository userRepository() {
        return new CSVUserRepository(Paths.get("./users.csv"));
    }

    @Bean
    public AddUserHandler addUserHandler(UserRepository userRepository, PasswordGenerator passwordGenerator) {
        return new DefaultAddUserHandler(userRepository, passwordGenerator);
    }
}
