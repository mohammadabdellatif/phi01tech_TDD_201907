package com.phi01tech.training;

import java.util.Random;

// too much scrolling
// small variable names
// maximum lines for method shouldn't be more than 10
// too much comments

// basics steps in any refactoring process:
// 1- renaming
// 2- scoping
// 3- extraction methods

// 6 to 10 lines
public class PasswordGenerator {

    public String generate() {
        Random random = new Random();
        String pass = selectLetters(random);
        pass += selectNumbers(random);
        pass += selectSymbols(random);
        return shufflePassword(pass, random);
    }

    private String shufflePassword(String pass, Random random) {
        String shuffled = "";
        for (int i = 0; i < 8; i++) {
            int selectedIndex = random.nextInt(pass.length());
            shuffled += pass.charAt(selectedIndex);
            pass = pass.substring(0, selectedIndex) + pass.substring(selectedIndex + 1);
        }
        return shuffled;
    }

    private String selectSymbols(Random random) {
        String symbols = "?!#_";
        String selection = "";
        for (int i = 0; i < 2; i++) {
            int selectedIndex = random.nextInt(symbols.length());
            selection += symbols.charAt(selectedIndex);
            symbols = symbols.substring(0, selectedIndex) + symbols.substring(selectedIndex + 1);
        }
        return selection;
    }

    private String selectNumbers(Random random) {
        String number = "0123456789";
        String selection = "";
        for (int i = 0; i < 2; i++) {
            int selectedIndex = random.nextInt(number.length());
            selection += number.charAt(selectedIndex);
            number = number.substring(0, selectedIndex) + number.substring(selectedIndex + 1);
        }
        return selection;
    }

    private String selectLetters(Random random) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String selection = "";
        for (int i = 0; i < 4; i++) {
            int selected = random.nextInt(letters.length());
            selection += letters.charAt(selected);
            letters = letters.substring(0, selected) + letters.substring(selected + 1);
        }
        return selection;
    }

}
