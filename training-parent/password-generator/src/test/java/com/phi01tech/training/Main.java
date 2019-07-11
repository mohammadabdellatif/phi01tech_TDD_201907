package com.phi01tech.training;

public class Main {

    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        System.out.println(passwordGenerator.generate());
        System.out.println(passwordGenerator.generate());
    }
}
