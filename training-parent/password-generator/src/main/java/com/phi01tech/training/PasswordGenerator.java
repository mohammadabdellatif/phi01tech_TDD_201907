package com.phi01tech.training;

import java.util.Random;

// refactoring
// long methods
// unclear variables names
// temporary variables (inlining)
// duplicate code
public class PasswordGenerator {
    public static final String SYMBOLS = "?!#_";
    public static final String NUMBERS = "0123456789";
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private Random random = new Random();

    public String generate() {
        StringBuilder pass = new StringBuilder();

        pass
                .append(select(LETTERS, 4, random))
                .append(select(NUMBERS, 2, random))
                .append(select(SYMBOLS, 2, random));
        return shufflePassword(pass, random);
    }

    private String shufflePassword(StringBuilder pass, Random random) {
        return select(pass.toString(), pass.length(), random);
    }

    private String select(String options, int count, Random random) {
        StringBuilder selected = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int selection = random.nextInt(options.length());
            selected.append(options.charAt(selection));
            options = removeSelectionFromOptions(options, selection);
        }
        return selected.toString();
    }

    private String removeSelectionFromOptions(String options, int selected) {
        return options.substring(0, selected) + options.substring(selected + 1);
    }
}
