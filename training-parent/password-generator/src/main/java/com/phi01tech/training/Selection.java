package com.phi01tech.training;

import java.util.Random;

public class Selection {
    private static final Random random = new Random();

    private final String options;
    private final int count;

    public static Selection of(String options, int count) {
        return new Selection(options, count);
    }

    public Selection(String options, int count) {
        this.options = options;
        this.count = count;
    }

    public String selectRandomly() {
        StringBuilder selected = new StringBuilder();
        String opt = options;

        for (int i = 0; i < count; i++) {
            int selectedIndex = random.nextInt(opt.length());
            selected.append(opt.charAt(selectedIndex));
            opt = removeSelectionFromOptions(opt, selectedIndex);
        }
        return selected.toString();
    }

    private String removeSelectionFromOptions(String options, int selected) {
        return options.substring(0, selected) + options.substring(selected + 1);
    }
}
