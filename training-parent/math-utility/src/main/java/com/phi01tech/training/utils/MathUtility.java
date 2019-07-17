package com.phi01tech.training.utils;

public class MathUtility {
    // 5! = 5*4*3*2*1

    public static int factorial(int number) {
        if (number < 0) {
            return factorial(-1 * number);
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
