package com.phi01tech.um.utils;

import java.util.UUID;

public class UUIDPasswordGenerator implements PasswordGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
