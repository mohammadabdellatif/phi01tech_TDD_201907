package com.phi01tech.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PasswordGeneratorTest {

    @RepeatedTest(10)
    public void whenGeneratorPassword_thenPasswordAsExpected() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generate();

        Assertions.assertNotNull(password, "password is null");
        Assertions.assertEquals(8, password.length(), "password length is not as expected");
        char[] chars = password.toCharArray();
        Map<String, ArrayList<Integer>> accurances = new HashMap<>();
        List<Character> special = Arrays.asList('?', '_', '!', '#');
        int index = 0;
        for (char part : chars) {
            String key = null;
            if (Character.isAlphabetic(part))
                key = "alpha";
            if (Character.isDigit(part)) {
                key = "digit";
            }
            if (special.contains(part)) {
                key = "special";
            }
            Assertions.assertNotNull(key, "unknown character");
            if (!accurances.containsKey(key)) {
                accurances.put(key, new ArrayList<>());
            }
            accurances.get(key).add(index++);
        }
        Assertions.assertEquals(4, accurances.get("alpha").size());
        Assertions.assertEquals(2, accurances.get("digit").size());
        Assertions.assertEquals(2, accurances.get("special").size());

        Set<String> keys = accurances.keySet();
        Map<String, Boolean> shuffled = new HashMap<>();
        mainloop:
        for (String key : keys) {
            ArrayList<Integer> indexes = accurances.get(key);
            int prev = indexes.get(0);
            for (int i = 1; i < indexes.size(); i++) {
                if (indexes.get(i) - prev > 1) {
                    shuffled.put(key, true);
                    continue mainloop;
                }
                prev = indexes.get(i);
            }
            shuffled.put(key, false);
        }
        int shuffledCount = 0;
        for (String key : shuffled.keySet()) {
            if (shuffled.get(key)) {
                shuffledCount++;
            }
        }
        Assertions.assertTrue((double) shuffledCount / shuffled.size() >= 0.25, "no strong shuffling: " + password);
    }
}
