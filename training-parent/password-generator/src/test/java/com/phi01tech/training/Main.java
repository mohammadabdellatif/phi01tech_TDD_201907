package com.phi01tech.training;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
                // extra check
        Selection selection = new Selection("1234",3);

        System.out.println(selection.selectRandomly());
        System.out.println(selection.selectRandomly());

//        PasswordGenerator passwordGenerator = new PasswordGenerator();
//
//        System.out.println(passwordGenerator.generate());
//        System.out.println(passwordGenerator.generate());
    }
}
