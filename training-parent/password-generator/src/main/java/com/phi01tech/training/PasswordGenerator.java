package com.phi01tech.training;

// refactoring
// long methods
// unclear variables names
// temporary variables (inlining)
// duplicate code
public class PasswordGenerator {
    public static final String SYMBOLS = "?!#_";
    public static final String NUMBERS = "0123456789";
    public static final String LOWER_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private Selection[] selections = new Selection[]{
            Selection.of(LOWER_LETTERS, 4),
            Selection.of(SYMBOLS, 2),
            Selection.of(NUMBERS, 2)
    };

    public String generate() {
        StringBuilder pass = new StringBuilder();

        for(Selection selection : selections) {
            pass.append(selection.selectRandomly());
        }

        return shufflePassword(pass);
    }

    public String shufflePassword(StringBuilder pass) {
        return Selection.of(pass.toString(), pass.length()).selectRandomly();
    }

}
