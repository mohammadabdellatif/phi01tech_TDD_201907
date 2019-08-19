package com.phi01tech.um.repo;

import com.phi01tech.um.User;
import com.phi01tech.um.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class CSVUserRepository implements UserRepository {
    // username,email,fullname,password
    private final Path csvPath;

    public CSVUserRepository(Path csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public boolean existsByUsername(String username) {
        return findFirst(line -> line[0].equalsIgnoreCase(username));
    }

    @Override
    public boolean existsByEmail(String email) {
        return findFirst(line -> line[1].equalsIgnoreCase(email));
    }

    private boolean findFirst(Predicate<String[]> predicate) {
        try {
            Optional<String[]> optional = Files.lines(csvPath)
                    .map(line -> line.split(","))
                    .filter(predicate)
                    .findFirst();
            return optional.isPresent();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(User user) {
        StringBuilder line = new StringBuilder();
        line.append(user.getUsername())
                .append(",")
                .append(user.getEmail())
                .append(",")
                .append(user.getFullName())
                .append(",")
                .append(user.getPassword());
        try {
            Files.write(csvPath, Arrays.asList(line.toString()),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
