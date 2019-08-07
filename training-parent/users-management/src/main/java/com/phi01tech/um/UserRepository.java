package com.phi01tech.um;

public interface UserRepository {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void save(User user);
}
